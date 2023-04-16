package me.spokenbot.controller;

import me.spokenbot.model.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
public class TestController {

    @GetMapping("get")
    public CommonResponse testGet(){
        return CommonResponse.success("你好");
    }

    @PutMapping("post")
    public CommonResponse test(@RequestParam("username") String username){
        return CommonResponse.success("你好");
    }
}
