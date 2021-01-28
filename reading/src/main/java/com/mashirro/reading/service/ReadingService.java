package com.mashirro.reading.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReadingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
//        String result = restTemplate.getForObject("http://localhost:9030/recommended", String.class);
        String result = restTemplate.getForObject("http://bookstore/recommended", String.class);
        return result;
    }

    private String reliable(){
        return " Learn Spring Cloud Netflix Circuit Breaker";
    }

}
