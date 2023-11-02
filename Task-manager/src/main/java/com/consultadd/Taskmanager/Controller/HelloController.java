package com.consultadd.Taskmanager.Controller;
//Sample Controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld()
    {
        return "Hello Ayush ,Welcome to consultadd ";
    }
}
