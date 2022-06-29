package com.example.springcamelbusexample.handlers;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


@Component
public class NonTransientErrorHandler implements Processor {
    @Override
    public void process(Exchange exchange) {

    }
}
