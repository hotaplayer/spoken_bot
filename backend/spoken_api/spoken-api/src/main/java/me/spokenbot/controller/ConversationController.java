package me.spokenbot.controller;

import me.spokenbot.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ConversationController {

    public ResponseEntity<CommonResponse> createConversation(){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<CommonResponse> deleteConversation(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/audio")
    public ResponseEntity<CommonResponse> upload(@RequestParam("audio") MultipartFile file) throws Exception{
        //1 获取audio bytes文件
        //2 bytes数据存入mysql
        //3 通知whisper前去处理
        return ResponseEntity.ok().build();
    }

    @PostMapping("/chat")
    public ResponseEntity<CommonResponse> chat(String chatId) throws Exception{
        //1 获取audio bytes文件
        //2 bytes数据存入mysql
        //3 通知whisper前去处理
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<CommonResponse> fetchResponse(@RequestParam("reqId") long reqId){
        return ResponseEntity.ok().build();
    }
}
