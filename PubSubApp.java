package com.pubsub;

import com.pubsub.core.Topic;
import com.pubsub.delivery.AtleastOnceDelivery;
import com.pubsub.delivery.AtmostOnceDelivery;
import com.pubsub.delivery.ExactlyOnceDelivery;
import com.pubsub.model.Message;
import com.pubsub.publisher.Publisher;
import com.pubsub.subscriber.Subscriber;
import com.pubsub.subscriber.SubscriberImpl;

import java.util.function.Predicate;

public class PubSubApp {
    public static void main(String[] args) {
        // filters
        Predicate<Message> None = msg -> true;
        Predicate<Message> onlyAI = msg -> msg.getMessage().contains("AI");
        Predicate<Message> NoKholi = msg -> !msg.getMessage().contains("Kholi");


        //Topics
        Topic technology = new Topic("Technology");
        Topic sports = new Topic("Sports");


        //Subscribers
        Subscriber eddieTech = new SubscriberImpl("Eddie", None, new AtleastOnceDelivery());
        technology.subscribe(eddieTech);

        Subscriber jacksonTech = new SubscriberImpl("Jackson", onlyAI, new AtmostOnceDelivery());
        technology.subscribe(jacksonTech);

        Subscriber johnSports = new SubscriberImpl("john", NoKholi, new ExactlyOnceDelivery());
        sports.subscribe(johnSports);


        //Publishers
        Publisher publisher = new Publisher();
        publisher.publish(new Message(technology.getTopic(), "Apple will go broke someday"), technology);
        publisher.publish(new Message(technology.getTopic(), "Now AI can do reasoning.."), technology);
        publisher.publish(new Message(sports.getTopic(), "Virat Kholi is leaving India!"), sports);
    }
}