package com.example.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){
        //특정 값들만을 받기 때문에 여러가지 값을 받을 일이 없다
        System.out.println(userId);
        System.out.println(account);
        //있으면 지우고 없으면 안 지운다 >> 항상 200을 return
    }
}
