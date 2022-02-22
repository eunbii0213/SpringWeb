package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        //id와 name을 받음
        System.out.println("get method");
        System.out.println(id);
        System.out.println(name);
        return id+" "+name;

    }
    @PostMapping("/post")
    public User post(@RequestBody User user){
        System.out.println(user);
        return user;
        //넘어온 user 찍어보기
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        //db logic
        //2초 후에 종료
        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println(user);

        return user;
        //넘어온 user 찍어보기
    }
}
