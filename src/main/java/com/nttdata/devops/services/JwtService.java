package com.nttdata.devops.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {

    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private String initialJwt;

    @PostConstruct
    public void init() {
        initialJwt = generateToken();
        System.out.println("🔹 Initial JWT: " + initialJwt); // Aparece en la consola al iniciar
    }

    public String getInitialJwt() {
        return initialJwt;
    }

    public String generateToken() {
        return Jwts.builder()
                .setSubject("transaction")
                .setId(UUID.randomUUID().toString())  // 🔹 ID único por token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 300000)) // 5 min
                .signWith(SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false; // Token inválido
        }
    }
}
