package com.example.put;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PostRequestDto put(@RequestBody PostRequestDto dto){
        System.out.println(dto);
        //rest controller인 경우에는 object 자체를 return 시키면
        // json으로 자동으로 바꿔준다! response
        return dto;
    }

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto dto, @PathVariable Long userId){
        System.out.println(userId);
        return dto;
    }
}
