package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-----------");
        //object mapper는 text형태의 json -> Object로 변환
        //object-> text json으로 변환

        //controller가 request형태로 json이 들어오면 자동적으로 object로 바꿔줌
        //response를 object형태로 리턴하면 자동적으로 json으로 바꿔줌


        var objectMapper = new ObjectMapper();

        //object -> text
        var user = new User("judith", 24);
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);
        //objectMapper가 getMethod를 활용하기 때문에 User에 getter있어야해
        //>> 다른 메소드에 get들어가지 않게 주의하며 코딩

        //text -> object

        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
        //text가 object로 바뀔 때는 object mapper가 dafault 생성자를 필요로 한다.


    }
}