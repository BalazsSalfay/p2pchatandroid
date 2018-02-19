package com.example.p2pchat.models;

import java.util.List;

public class MessageResponse {

    private List<Message> messages;
    private Client client;

    public MessageResponse() {
    }

    public MessageResponse(List<Message> messages, Client client) {
        this.messages = messages;
        this.client = client;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
