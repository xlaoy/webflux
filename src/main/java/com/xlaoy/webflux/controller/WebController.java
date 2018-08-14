package com.xlaoy.webflux.controller;

import io.netty.util.internal.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.time.Duration;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@RestController
public class WebController {

    private Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/webflux/hello")
    public Mono<String> hello() {
        return Mono.just("wocao");
    }

    @GetMapping("/webflux/log")
    public Flux<ServerSentEvent> log() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> {
                    String data = "" + seq.intValue();
                    logger.info(">>>"  + data);
                    return ServerSentEvent.builder(data).build();
                });
    }
}
