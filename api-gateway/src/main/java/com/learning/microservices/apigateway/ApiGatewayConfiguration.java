package com.learning.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    
    @Bean
    public RouteLocator gatewayRouteRouter(RouteLocatorBuilder builder) {
        Function<PredicateSpec, Buildable<Route>> routeFunction
            = p -> p.path("/get")
                    .filters(filter -> filter
                                        .addRequestHeader("headerName", "headerValue")
                                        .addRequestParameter("param", "myvalue"))
                    .uri("http://httpbin.org:80");

        Function<PredicateSpec, Buildable<Route>> currencyExchangeFunction
            = p -> p.path("/currency-exchange/**")
                    .uri("lb://currency-exchange-service/");
        Function<PredicateSpec, Buildable<Route>> currencyConversionFunction
            = p -> p.path("/currency-conversion/**")
                    .uri("lb://currency-conversion/");
        Function<PredicateSpec, Buildable<Route>> rewriteRoutePathFunction 
            = p -> p.path("/currency-conversion-new/**")
                    .filters(f -> f.rewritePath(
                                    "/currency-conversion-new/(?<segment>.*", 
                                    "/currency-conversion/${segment}"))
                    .uri("lb://currency-conversion");
        return builder
                .routes()
                .route(routeFunction)
                .route(currencyExchangeFunction)
                .route(currencyConversionFunction)
                .route(rewriteRoutePathFunction)
                .build();
    }

}
