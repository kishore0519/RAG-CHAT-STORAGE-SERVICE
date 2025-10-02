package com.kj.chat.service;

import org.springframework.stereotype.Service;

import com.kj.chat.model.Message;
import com.kj.chat.model.Session;

import java.util.List;

@Service
public class MessageService {
    private final SessionService sessionService;

    public MessageService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public Message addMessage(String sessionId, Message message) {
        Session s = sessionService.getSession(sessionId).orElseThrow(() -> new RuntimeException("Session not found"));
        s.getMessages().add(message);
        return message;
    }

    public List<Message> getMessages(String sessionId) {
        Session s = sessionService.getSession(sessionId).orElseThrow(() -> new RuntimeException("Session not found"));
        return s.getMessages();
    }
}
