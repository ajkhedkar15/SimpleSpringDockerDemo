package com.example.dockerDemo.router;

import com.example.dockerDemo.handler.DockerDemoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class DockerDemoRouter {

    private DockerDemoHandler handler;

    @Autowired
    public DockerDemoRouter(DockerDemoHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<?> dockerDemoRoute(){
        return RouterFunctions.route(RequestPredicates.GET("/dockerDemo"),
                handler::getResponse);
    }
}
