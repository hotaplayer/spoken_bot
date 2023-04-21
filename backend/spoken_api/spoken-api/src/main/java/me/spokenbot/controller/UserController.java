package me.spokenbot.controller;

import me.spokenbot.model.response.CommonResponse;
import me.spokenbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) throws Exception{
        CommonResponse response = userService.login(username, password);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("register")
    public ResponseEntity<CommonResponse> register(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) throws Exception{
        CommonResponse response = userService.register(username, password);
        return ResponseEntity.ok().body(response);
    }

}
