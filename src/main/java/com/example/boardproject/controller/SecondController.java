package com.example.boardproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller

public class SecondController {
    @GetMapping("/main")
    @ResponseBody
    public String main1() {
        return "<h1>hello!</h1>";
    }
    @GetMapping("/now")
    @ResponseBody
    public String now1(){
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        String html = String.format("오늘은 %d월 %d일 입니다.", month, day);
        return html;
    }
    @GetMapping("/now2")
    @ResponseBody
    public String now2(){
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        String html = String.format("<h1>오늘은 %d월 %d일 입니다.</h1>", month, day);
        return html;
    }
    int cnt = 123;
    @GetMapping("/count")
    @ResponseBody
    public String count(){
        cnt += 1;
        return Integer.toString(cnt);
    }
    @GetMapping("/count2")
    @ResponseBody
    public String count2(){
        cnt += 1;
        String imgCnt = Integer.toString(cnt);
        String result = "";
        for (int i = 0; i < imgCnt.length(); i++){
            result += String.format("<img src='%s.png' width='100' height='100'>", imgCnt.charAt(i));
        }

        System.out.println(result);
        return result;
    }
    @GetMapping("/Banner")
    @ResponseBody
    public String Banner() {
        String[] urls = {
                "https://www.daum.net",
                "https://www.naver.com",
                "https://www.google.com"
        };

        String[] images = {
                "daum.jpg",
                "naver.jpg",
                "google.jpg"
        };

        String result = "";

        for (int i = 0; i < urls.length; i++) {
            result += String.format(
                    "<a href='%s' target='_blank'>" +
                            "<img src='/%s' width='100' height='100' style='margin-right:10px;'>" +
                            "</a>",
                    urls[i], images[i]
            );
        }

        return result;
    }
}

