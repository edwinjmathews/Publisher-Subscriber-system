package com.pubsub.subscriber;

import com.pubsub.delivery.DeliveryStrategy;
import com.pubsub.model.Message;

import java.util.function.Predicate;

public class SubscriberImpl implements Subscriber {
    private final String name;
    private Predicate<Message> filter;
    private DeliveryStrategy deliveryStrategy;

    public SubscriberImpl(String name, Predicate<Message> filter, DeliveryStrategy deliveryStrategy) {
        this.name = name;
        this.filter = filter;
        this.deliveryStrategy = deliveryStrategy;
    }

    @Override
    public void receive(Message message) {
        System.out.println(name + " received " + message.getTopic() + " message: " + message.getMessage());
    }

    @Override
    public Predicate<Message> getFilter() {
        return filter;
    }

    @Override
    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}