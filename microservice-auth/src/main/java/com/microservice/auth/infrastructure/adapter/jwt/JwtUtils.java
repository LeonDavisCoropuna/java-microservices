package com.microservice.auth.infrastructure.adapter.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.microservice.auth.application.services.UserDetailsImpl;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static final String SECRET_KEY ="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    private static final int JWT_EXPIRATION_TIME = 1000*100;

    public String generateJwtToken(Authentication authentication){
        return generateJwtToken(authentication,new HashMap<>());
    }

    public String generateJwtToken(Authentication authentication, Map<String, Object> claims) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION_TIME))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public List<String> getUserRolesFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
        return (List<String>) claims.get("roles");
    }


    public boolean validateJwtToken(String authToken) {
        try {
            verifyTokenSignature(authToken);
            return true;
        } catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            handleTokenError(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return false;
    }

    private void verifyTokenSignature(String authToken) {

        Key key = key();

        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

        // Verifica si el token está firmado
        if (!jwtParser.isSigned(authToken)) {
            throw new MalformedJwtException("JWT token is not signed");
        }
        // El token está firmado, realiza el análisis del contenido
        jwtParser.parseClaimsJws(authToken);
    }

    private void handleTokenError(String errorMessage) {
        logger.error(errorMessage);
    }

}