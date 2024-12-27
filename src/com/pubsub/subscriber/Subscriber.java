package com.pubsub.subscriber;

import com.pubsub.delivery.DeliveryStrategy;
import com.pubsub.model.Message;

import java.util.function.Predicate;

public interface Subscriber {
    void receive(Message message);

    Predicate<Message> getFilter();

    DeliveryStrategy getDeliveryStrategy();
}
