package com.bananaapps.bananamusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    @GetMapping("/song")
    public String getSong(){
        return "SONG";
    }

    @GetMapping("/user")
    public String getUser(){
        return "USER";
    }

    @GetMapping("/order")
    public String getOrder(){
        return "ORDER";
    }
}
