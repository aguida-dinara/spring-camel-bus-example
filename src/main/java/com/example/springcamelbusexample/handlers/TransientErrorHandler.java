package com.example.springcamelbusexample.handlers;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.spi.ErrorHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransientErrorHandler implements ErrorHandler {

    @Override
    public void process(Exchange exchange) {
        log.info("This is the final destination of the event when the retries fail");
        log.info("Sending this message to jail -> alerting Ops team");
    }
}
