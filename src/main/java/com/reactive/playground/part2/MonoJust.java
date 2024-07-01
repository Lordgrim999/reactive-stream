package com.reactive.playground.part2;

import com.reactive.playground.part1.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class MonoJust {
    public static void main(String[] args) {
        Mono<String> rishi = Mono.just("Rishi");
        var subscriber = new SubscriberImpl();
        rishi.subscribe(subscriber);
        subscriber.getSubscription().request(10);
    }
}
