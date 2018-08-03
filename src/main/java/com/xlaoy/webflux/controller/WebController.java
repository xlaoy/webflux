package com.xlaoy.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@RestController
public class WebController {

    @GetMapping("/webflux/hello")
    public Mono<String> hello() {
        return Mono.just("wocao");
    }
}
