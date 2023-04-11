package me.spokenbot.controller;

import me.spokenbot.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ConversationController {

    public ResponseEntity<CommonResponse> createConversation(){

    }

    public ResponseEntity<CommonResponse> deleteConversation(){

    }

    @PostMapping("/audio")
    public ResponseEntity<CommonResponse> upload(@RequestParam("audio") MultipartFile file) throws Exception{

    }

    @GetMapping
    public ResponseEntity<CommonResponse> fetchResponse(@RequestParam("reqId") long reqId){

    }


}
