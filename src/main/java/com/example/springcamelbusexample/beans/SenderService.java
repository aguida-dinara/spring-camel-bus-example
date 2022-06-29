package com.example.springcamelbusexample.beans;

import com.example.springcamelbusexample.dtos.MyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderService {

    MyDto run(){
        log.info("Starting to send message to myQueue");
        return MyDto.builder().foo("Hello").bar("World").build();
    }

}
