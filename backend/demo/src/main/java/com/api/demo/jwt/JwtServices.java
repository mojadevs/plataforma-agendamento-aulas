package com.api.demo.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServices {

    private static final String SECRET_KEY = "minhaChaveSuperSecreta123"; // guarde em config segura
    private static final long EXPIRATION = 1000 * 60 * 60 * 2; // 2 horas

    // Gerar token
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validar token
    public boolean isTokenValid(String token, String email) {
        return email.equals(getEmail(token)) && !isTokenExpired(token);
    }

    // Extrair email do token
    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    // Verificar expiração
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
