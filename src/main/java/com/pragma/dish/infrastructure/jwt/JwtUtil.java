package com.pragma.dish.infrastructure.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


@Component
public class JwtUtil {

    private final String ACCESS_TOKEN_SECRET = "Zy1vNcA3rBpX7LsGt49qWeJkMmPnRtUv";

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).build().parseClaimsJws(token);
           // getClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}

