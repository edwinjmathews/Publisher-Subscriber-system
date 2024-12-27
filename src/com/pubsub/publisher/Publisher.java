package com.pubsub.publisher;

import com.pubsub.core.Topic;
import com.pubsub.model.Message;

public class Publisher {
    public void publish(Message message, Topic topic) {
        topic.publish(message);
    }
}
