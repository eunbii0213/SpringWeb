package com.example.springioc;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        Base64Encoder base = context.getBean(Base64Encoder.class);
        Encoder encoder = context.getBean(Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);



        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
        encoder.setiEncoder(urlEncoder);
        result = encoder.encode(url);
        System.out.println(result);


        //beam 찾는 법 >> 1. 이름 2. 타입
    }

}
