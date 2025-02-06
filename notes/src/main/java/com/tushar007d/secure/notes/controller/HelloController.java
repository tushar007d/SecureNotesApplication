package com.tushar007d.secure.notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/contact")
    public String contact(){
        return "Contact";
    }

}
