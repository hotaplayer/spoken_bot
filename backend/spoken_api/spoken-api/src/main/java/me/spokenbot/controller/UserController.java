package me.spokenbot.controller;

import me.spokenbot.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")
public class UserController {

    @GetMapping
    public ResponseEntity<CommonResponse> login(){

    }

    @PostMapping
    public ResponseEntity<CommonResponse> register(){

    }

}
