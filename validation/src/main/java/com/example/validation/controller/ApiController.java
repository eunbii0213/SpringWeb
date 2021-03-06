package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user") //validation의 결과가 bindingResult에 들어옴
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){
        System.out.println(user);
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError)objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field" +field.getField());
                System.out.println(message);

                sb.append("field : "+field.getField());
                sb.append("message : "+ message);

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
//        if(user.getPhoneNumber() == "xxx-xxxx-xxxx"){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
//        if(user.getAge()>=90){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
        return ResponseEntity.ok(user);
    }

}
