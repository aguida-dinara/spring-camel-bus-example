//package com.example.springcamelbusexample.configs;
//
//import com.azure.messaging.servicebus.ServiceBusClientBuilder;
//import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
//import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;
//import org.apache.camel.component.azure.servicebus.springboot.ServiceBusComponentAutoConfiguration;
//import org.apache.camel.component.azure.servicebus.springboot.ServiceBusComponentConfiguration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ConsumerConfig {
//
//    @Autowired
//    ServiceBusComponentAutoConfiguration serviceBusComponentAutoConfiguration;
//    @Autowired
//    ServiceBusComponentConfiguration configuration;
//
//    @Bean
//    ServiceBusReceiverAsyncClient serviceBusReceiverAsyncClient(){
//
//        return new ServiceBusClientBuilder()
////                .retryOptions()
////                .connectionString(CONNECTION_STRING)
//                .receiver()
//                .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
//                .prefetchCount(20)
////                .queueName(QUEUE_NAME)
//                .buildAsyncClient();
//    }
//}
