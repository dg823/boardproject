package com.example.boardproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThirdController {

    @GetMapping("/users/{username}")
    @ResponseBody
    public String getUserInfo(@PathVariable String username){
        return "hello, " + username + "!!";
    }

    @GetMapping("sum/{num}")
    @ResponseBody
    public String sum(@PathVariable Integer num) {
        int total = 0;

        for(int i = 1; i <= num; i++){
            total += i;
        }

        return String.format("<h1>1부터 %d까지의 합은 %d입니다.</h1>", num, total);
    }

    @GetMapping("/users/{username}/orders/{ordernum}")
    @ResponseBody
    public String orders(@PathVariable String username, @PathVariable Integer ordernum) {
        return String.format("%s 유저가 주문 번호가 %d인 상품 출력", username, ordernum);
    }

    @GetMapping("/posts/{category}/{postid}")
    @ResponseBody
    public String posts(@PathVariable String category, @PathVariable Integer postid) {
        return String.format("category가 %s인 게시물 중 %d번 글", category, postid);
    }
}
