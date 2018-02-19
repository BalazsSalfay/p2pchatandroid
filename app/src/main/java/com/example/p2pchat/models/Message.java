package com.example.p2pchat.models;

import java.time.LocalDateTime;

public class Message {

    private long id;
    private String timestamp;
    private String username;
    private String text;

    public Message() {
        Long tsLong = System.currentTimeMillis()/1000;
        this.timestamp = tsLong.toString();
    }

    public Message(String username, String text) {
        Long tsLong = System.currentTimeMillis()/1000;
        this.username = username;
        this.text = text;
        this.id = randomGeneratedId();
        this.timestamp = tsLong.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = randomGeneratedId();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long randomGeneratedId() {
        return (long) (Math.random() * 99999999 + 1000000 );
    }
}