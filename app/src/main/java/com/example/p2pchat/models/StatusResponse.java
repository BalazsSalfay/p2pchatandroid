package com.example.p2pchat.models;

public class StatusResponse {

    private Message message;
    private Client client;

    public StatusResponse() {
    }

    public StatusResponse(Message message, Client client) {
        this.message = message;
        this.client = client;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
