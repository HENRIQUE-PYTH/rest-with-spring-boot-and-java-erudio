package com.Henrique.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Henrique.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

    private static final String template = "Hello, %s! ";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?nome=henrique
    @GetMapping
    public ResponseEntity<Greeting> greeting(
            @RequestParam(value = "nome", defaultValue = "Henrique")
            String name){
        return ResponseEntity.ok(new Greeting (counter.incrementAndGet(), String.format(template, name)));
    }

}
