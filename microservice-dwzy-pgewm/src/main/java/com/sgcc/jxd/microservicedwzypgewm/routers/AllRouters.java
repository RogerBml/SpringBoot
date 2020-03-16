package com.sgcc.jxd.microservicedwzypgewm.routers;

import com.sgcc.jxd.microservicedwzypgewm.pgewmhandlers.Pgewmhandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AllRouters {
    @Bean
    RouterFunction<ServerResponse> pgewmRouter(Pgewmhandler handle){
        return RouterFunctions.nest(
                RequestPredicates.path("/pgewm"),
                RouterFunctions.route(RequestPredicates.GET("/list"),
                        handle::getAllPgewm)
                .andRoute(RequestPredicates.POST("/create").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
                        handle::createPgewm)
                .andRoute(RequestPredicates.DELETE("/delete/{id}"),
                        handle::deletePgewm)

        );

    }
}
