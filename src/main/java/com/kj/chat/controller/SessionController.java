package com.kj.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kj.chat.model.Session;
import com.kj.chat.service.SessionService;

import java.util.Collection;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<Session> create(@RequestParam String name) {
        Session s = sessionService.createSession(name);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<Collection<Session>> list() {
        return ResponseEntity.ok(sessionService.listSessions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/rename")
    public ResponseEntity<Void> rename(@PathVariable String id, @RequestParam String name) {
        sessionService.renameSession(id, name);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<Void> favorite(@PathVariable String id, @RequestParam boolean fav) {
        sessionService.setFavorite(id, fav);
        return ResponseEntity.noContent().build();
    }
}
