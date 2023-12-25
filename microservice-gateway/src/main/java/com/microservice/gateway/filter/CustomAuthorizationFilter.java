package com.microservice.gateway.filter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;


@Component
public class CustomAuthorizationFilter extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            // Aquí realizas la lógica de validación del token
            // Puedes acceder a la solicitud actual con exchange.getRequest()

            // Ejemplo: Validación de token JWT
            if (isValidToken(exchange)) {
                return chain.filter(exchange);
            } else {
                // Si la validación falla, puedes devolver una respuesta de error o redirigir a otra ubicación
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        };
    }

    private boolean isValidToken(ServerWebExchange exchange) {
        // Implementa la lógica de validación de token aquí
        // Puedes acceder a la solicitud actual con exchange.getRequest()

        // Ejemplo: Verificar la presencia y validez del token en el encabezado de autorización
        String authorizationHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return isValidJwtToken(authorizationHeader);
    }

    private boolean isValidJwtToken(String token) {
        // Implementa la lógica de validación de token JWT aquí
        // Puedes utilizar bibliotecas como jjwt para validar tokens JWT

        // Este es solo un ejemplo. Debes adaptarlo a tus necesidades específicas.
        return StringUtils.hasText(token) && token.startsWith("Bearer ");
    }
}