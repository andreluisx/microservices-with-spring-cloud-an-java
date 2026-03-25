package com.rest_with_spring.rest_with_spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/teste")
    public String testeLog(){
        logger.debug("This is a Degub log");
        logger.warn("This is a Warn log");
        logger.info("This is a info log");
        logger.error("This is a Error log");
        return "log is successfull";
    }


}
