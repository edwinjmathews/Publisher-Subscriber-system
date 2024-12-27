package com.pubsub.model;

public class Message {
    private final String topic;
    private final String message;

    public Message(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }
}
