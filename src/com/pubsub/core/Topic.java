package com.pubsub.core;

import com.pubsub.model.Message;
import com.pubsub.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String topic;
    private List<Subscriber> subscribers = new ArrayList<>();

    public Topic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(Message message) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getFilter().test(message)) {
                subscriber.getDeliveryStrategy().deliver(subscriber, message);
            }
        }
    }
}
