package com.ford.poc.c2c.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/c2c/consumer/")
public class ConsumerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getapplist")
    public String getApplicationList() {
        String response = "";
        try {

            URI uri = UriComponentsBuilder.fromUriString("//PROVIDERAPI/c2c/provider/fetchappdetail").build().toUri();
//            response = restTemplate.getForObject(URL, String.class);
            response = restTemplate.getForObject(uri, String.class);
        } catch (Exception ex) {
            logger.error("Exception while calling provider app, ErrorMsg: [{}]", ex.getMessage());
            ex.printStackTrace();
            response = "Exception while calling provider app "+ex.getMessage();
        }
        return response;
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
