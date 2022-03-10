package com.pi.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping(value="/choma")
    public String test() throws Exception {
        System.out.println("choma");
        return "";
    }
}
