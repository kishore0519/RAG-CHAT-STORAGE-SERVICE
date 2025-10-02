package com.kj.chat.service;

import org.springframework.stereotype.Service;

import com.kj.chat.model.Session;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionService {
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();

    public Session createSession(String name) {
        String id = UUID.randomUUID().toString();
        Session s = new Session(id, name);
        sessions.put(id, s);
        return s;
    }

    public Optional<Session> getSession(String id) {
        return Optional.ofNullable(sessions.get(id));
    }

    public Collection<Session> listSessions() {
        return sessions.values();
    }

    public void deleteSession(String id) {
        sessions.remove(id);
    }

    public void renameSession(String id, String newName) {
        Session s = sessions.get(id);
        if (s != null) s.setName(newName);
    }

    public void setFavorite(String id, boolean fav) {
        Session s = sessions.get(id);
        if (s != null) s.setFavorite(fav);
    }
}
