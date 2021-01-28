package com.mashirro.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {

    @RequestMapping("/recommended")
    public String readList(HttpServletRequest request) {
        return "Spring in Action, Thinking in Java from " + request.getRequestURL().toString();
    }
}
