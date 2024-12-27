package com.pubsub.delivery;

import com.pubsub.model.Message;
import com.pubsub.subscriber.Subscriber;

public class AtmostOnceDelivery implements DeliveryStrategy{
    @Override
    public void deliver(Subscriber subscriber, Message message) {
        subscriber.receive(message);
    }
}
