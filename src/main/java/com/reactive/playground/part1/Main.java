package com.reactive.playground.part1;

import com.reactive.playground.part1.publisher.PublisherImpl;
import com.reactive.playground.part1.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       demo();
    }

    public static void demo() throws InterruptedException {
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
    }
}