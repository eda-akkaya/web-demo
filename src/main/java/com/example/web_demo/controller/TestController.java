package com.example.web_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") // Tüm isteklere ön ek ekler.
public class TestController {

    @GetMapping({"/hello","/merhaba"})
    public String sayHi(@RequestParam(defaultValue="kullanıcı") String name,
                        @RequestParam() int age){ // default query string
        return "Merhaba" + name + ", yaşınız: " + age;
    }
}
