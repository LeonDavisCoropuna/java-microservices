package com.microservice.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;


@Component
public class CustomAuthorizationFilter extends AbstractGatewayFilterFactory<CustomAuthorizationFilter.Config> {

    public CustomAuthorizationFilter() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Verifica la lógica de autorización aquí
            if (isAuthorized(exchange, config)) {
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }
        };
    }

    private boolean isAuthorized(ServerWebExchange exchange, Config config) {
        // Implementa la lógica de autorización según tus necesidades
        // Puedes verificar encabezados, tokens, roles, etc.
        // En este ejemplo, simplemente permitimos todo (puedes cambiar esto según tus requisitos)
        return false;
    }

    public static class Config {
        // Puedes agregar configuraciones específicas si es necesario
    }
}
