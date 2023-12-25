package com.microservice.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomAuthorizationFilter extends AbstractGatewayFilterFactory<CustomAuthorizationFilter.Config> {

    public CustomAuthorizationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Aquí puedes obtener el valor que deseas verificar, por ejemplo, desde un encabezado o un atributo de la solicitud
            boolean shouldAllow = false;

            if (shouldAllow) {
                // Si el valor es true, permitir la solicitud
                return chain.filter(exchange);
            } else {
                // Si el valor es false, bloquear la solicitud y devolver un código de estado 403 (Prohibido)
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }
        };
    }

    public static class Config {
        private boolean allow;

        public boolean isAllow() {
            return allow;
        }

        public void setAllow(boolean allow) {
            this.allow = allow;
        }
    }
}
