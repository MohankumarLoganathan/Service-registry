package com.ford.poc.provider.c2c.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c2c/provider")
public class ProviderController {

    @RequestMapping(value = "/fetchappdetail")
    public String getAppList(){
        System.out.println("Provider service is called");
        return "Response from provider app";
    }
}
