package com.example.springcamelbusexample.routes;

import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
import com.example.springcamelbusexample.beans.ReceiverService;
import com.example.springcamelbusexample.beans.SenderService;
import com.example.springcamelbusexample.dtos.MyDto;
import com.example.springcamelbusexample.exceptions.TransientErrorException;
import com.example.springcamelbusexample.handlers.TransientErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.DeadLetterChannelBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootRouter extends RouteBuilder {

    @Autowired
    private SenderService senderService;

    @Autowired
    private ReceiverService receiverService;

    @Autowired
    private TransientErrorHandler transientErrorHandler;

    private static final String MY_ROUTE = "azure-servicebus:test-camel";
    private static final String MY_ROUTE_DLQ = "azure-servicebus:test-camel.dlq";

    @Override
    public void configure() {
        ObjectMapper objectMapper = new ObjectMapper();

        JacksonDataFormat jsonDataFormat = new JacksonDataFormat();
        jsonDataFormat.setObjectMapper(objectMapper);

        onException(TransientErrorException.class)
                .routeId("FooTrans route")
                .log(LoggingLevel.INFO, "Sending to DEAD_LETTER_QUEUE")
                .useOriginalMessage()
                .process(transientErrorHandler)
                .marshal(jsonDataFormat)
                .to(MY_ROUTE_DLQ)
                .log(LoggingLevel.INFO, "Sending to DEAD_LETTER_QUEUE")
                .end();

        from("timer://simpleTimer?period=10000").routeId("sender")
                .log(LoggingLevel.INFO, "Sending message to myQueue")
                .bean(senderService, "run")
                .setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
                .marshal(jsonDataFormat)
                .to(MY_ROUTE);


        from(MY_ROUTE).routeId("receiver")
                .convertBodyTo(String.class)
                .log(LoggingLevel.INFO,"RESPONSE: ${body}")
                .unmarshal().json(MyDto.class)
                .bean(receiverService, "receive")
                .log(LoggingLevel.INFO,"Received message from myQueue")
                .to("stream:out")
                .end();
    }

}
