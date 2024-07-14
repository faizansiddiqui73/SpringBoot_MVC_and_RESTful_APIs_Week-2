package com.codingShuttle.com.faizan.week2.springbootwebtutorial.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmplyeeController {

    @GetMapping("/")
    public String getServer() {
        return "Hello from spring sever";
    }

    String msg = "Honey";

    @GetMapping(path = "/getSecretMessage")
    public String getMySecretMessage() {
        return "Here is my seceret message : " + msg;
    }
}
