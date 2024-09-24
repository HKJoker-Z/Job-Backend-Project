package com.z2.showZ2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * this is a controller class
 * **/

@RestController //it's a controller annotation
public class Controller001 {

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    
}
