package com.example.springcamelbusexample.beans;

import com.example.springcamelbusexample.dtos.MyDto;
import com.example.springcamelbusexample.exceptions.TransientErrorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.azure.servicebus.ServiceBusComponent;
import org.apache.camel.component.azure.servicebus.ServiceBusConfiguration;
import org.apache.camel.component.azure.servicebus.springboot.ServiceBusComponentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiverService {

    public void receive(MyDto myDto){
        log.info("Starting to process received event id: {}", myDto.getId());
        log.info("Message received: ", myDto.toString());
        log.info("Finished processing received event: {}", myDto.getId());
        throw new TransientErrorException("expected transient!");
    }
}
