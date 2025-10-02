package com.kj.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kj.chat.model.Message;
import com.kj.chat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/sessions/{sessionId}/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> add(@PathVariable String sessionId, @RequestBody Message message) {
        Message m = messageService.addMessage(sessionId, message);
        return ResponseEntity.ok(m);
    }

    @GetMapping
    public ResponseEntity<List<Message>> list(@PathVariable String sessionId) {
        return ResponseEntity.ok(messageService.getMessages(sessionId));
    }
}
