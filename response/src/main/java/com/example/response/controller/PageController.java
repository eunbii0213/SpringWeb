package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//html page의 리소스를 찾음
@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //ResponseEntity
    @ResponseBody //객체 자체를 return 했을 때 resource를 찾지않고 response body를 만들어서 resource 내린다는 뜻
    @GetMapping("/user")
    public User user(){
        var user = new User();
        user.setName("judith");
        user.setAddress("south korea");
        return user;
    }
}
