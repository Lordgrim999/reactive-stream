package com.reactive.playground.part2;

import com.reactive.playground.part1.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class MonoJustSubscribe {
    private final static Logger log= LoggerFactory.getLogger(MonoJustSubscribe.class);
    public static void main(String[] args) {
        Mono<String> rishi = Mono.just("Rishi")
                .map(String::toUpperCase);

        rishi.subscribe(value->log.info("value emitted {}",value),
                        error->log.error("erorr",error),
                        ()->log.info("completed"),
                        subscription -> subscription.request(10)
                );

    }
}
