package me.spokenbot.controller;

import me.spokenbot.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @PostMapping("login")
    public ResponseEntity login(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        return ResponseEntity.ok().body(username);
    }

    @PostMapping("register")
    public ResponseEntity<CommonResponse> register(){
        return ResponseEntity.ok().build();
    }
    
}
