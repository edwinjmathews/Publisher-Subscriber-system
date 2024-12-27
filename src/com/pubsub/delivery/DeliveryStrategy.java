package com.pubsub.delivery;

import com.pubsub.model.Message;
import com.pubsub.subscriber.Subscriber;

/**
 * Delivery Guarantee Strategy: Atleast-once, Atmost-once, Exactly-once
 */
public interface DeliveryStrategy {
    void deliver(Subscriber subscriber, Message message);
}
