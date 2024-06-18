package com.reactive.playground.part1.publisher;

import com.github.javafaker.Faker;
import com.reactive.playground.part1.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final int MAX_ITEMS=10;
    private final Faker faker;
    private int count=0;
    private static final Logger log= LoggerFactory.getLogger(SubscriptionImpl.class);

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber=subscriber;
        this.faker=Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(isCancelled)
            return;
        log.info("Subscriber requested for {} items",requested) ;
        for(int i=0;i<requested && count<MAX_ITEMS;i++)
        {
            count++;
            subscriber.onNext(faker.internet().emailAddress());
        }
        if(count==MAX_ITEMS)
        {
            log.info("No more data to produce");
            subscriber.onComplete();
            this.isCancelled=true;
        }
    }

    @Override
    public void cancel() {
        log.info("subscription is cancelled");
    }
}
