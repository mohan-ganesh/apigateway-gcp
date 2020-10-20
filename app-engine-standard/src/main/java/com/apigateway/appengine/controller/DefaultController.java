package com.apigateway.appengine.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DefaultController {

    public static Log logger = LogFactory.getLog(DefaultController.class);

    @RequestMapping (path="/", method= RequestMethod.GET)
    public ResponseEntity hello()  {
        return ResponseEntity.ok("up");

    }
}
