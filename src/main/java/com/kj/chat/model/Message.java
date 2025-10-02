package com.kj.chat.model;

public class Message {
    private String sender;
    private String content;
    private String context;

    public Message() {}

    public Message(String sender, String content, String context) {
        this.sender = sender;
        this.content = content;
        this.context = context;
    }

    public String getSender() { 
        return sender; 
    }
    public void setSender(String sender) { 
        this.sender = sender; 
    }
    public String getContent() { 
        return content; 
    }
    public void setContent(String content) {
         this.content = content; 
        }
    public String getContext() { 
        return context; 
    }
    public void setContext(String context) {
         this.context = context; 
    }
}
