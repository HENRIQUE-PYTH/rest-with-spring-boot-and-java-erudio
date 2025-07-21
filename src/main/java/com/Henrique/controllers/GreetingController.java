package com.Henrique.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Henrique.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! ";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?nome=henrique
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "nome", defaultValue = "Henrique")
            String name){
        return new Greeting (counter.incrementAndGet(), String.format(template, name));


    }

}
