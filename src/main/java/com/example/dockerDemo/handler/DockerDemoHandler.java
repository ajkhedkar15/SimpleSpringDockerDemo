package com.example.dockerDemo.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DockerDemoHandler {

    public Mono<ServerResponse> getResponse(ServerRequest request){
        return ServerResponse.ok().body(BodyInserters
                    .fromObject("Hello World!!!"));
    }
}
