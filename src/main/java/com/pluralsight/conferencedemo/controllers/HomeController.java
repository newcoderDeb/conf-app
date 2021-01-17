package com.pluralsight.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {
    @Value("${app.owner}")
    private String appOwner;
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    Map<String, String> homePage(){
        Map<String, String> info = new HashMap();
        info.put("appOwner",appOwner);
        info.put("appVersion", appVersion);
        return info;
    }
}
