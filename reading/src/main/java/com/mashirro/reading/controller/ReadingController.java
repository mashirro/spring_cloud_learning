package com.mashirro.reading.controller;

import com.mashirro.reading.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadingController {

    @Autowired
    private ReadingService readingService;


    @RequestMapping("/read")
    public String toRead() {
        return readingService.readingList();
    }

}
