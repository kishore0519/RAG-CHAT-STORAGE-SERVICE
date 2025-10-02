package com.kj.chat.model;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private String id;
    private String name;
    private boolean favorite;
    private List<Message> messages = new ArrayList<>();

    public Session() {}

    public Session(String id, String name) {
        this.id = id;
        this.name = name;
        this.favorite = false;
    }

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public boolean isFavorite() { 
        return favorite; 
    }
    public void setFavorite(boolean favorite) { 
        this.favorite = favorite; 
    }
    public List<Message> getMessages() { 
        return messages; 
    }
    public void setMessages(List<Message> messages) { 
        this.messages = messages; 
    }
}
