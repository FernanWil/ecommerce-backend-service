package com.ecommerce.springBoot.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String base64Key;

//    // Aquí guardaremos la llave ya procesada en memoria
//    private SecretKey cryptographicKey;
//
//    @PostConstruct
//    public void init() {
//        // 2. Se ejecuta UNA SOLA VEZ al arrancar el servidor.
//        // Decodifica el String Base64 y lo convierte en un objeto SecretKey válido.
////        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
////        this.cryptographicKey = Keys.hmacShaKeyFor(decodedKey);
//
//        // 1. Decodifica usando el estándar exacto de la librería io.jsonwebtoken
//        byte[] decodedKey = Decoders.BASE64URL.decode(base64Key);
//        // 2. Genera la llave criptográfica segura
//        this.cryptographicKey = Keys.hmacShaKeyFor(decodedKey);
//    }

// 2. Generamos el SecretKey dinámicamente asegurando la consistencia de los bytes
    private SecretKey getSigningKey() {
        byte[] keyBytes = this.base64Key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        System.out.println("USERNAME ISTOKENVALID: " + username);
        // Ambos deben representar el email del usuario para que retorne true
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        System.out.println("DENTRO DE ISTOKENEXPIRED= "+ token);
        return extracExpiration(token).before(new Date());
    }

    public Date extracExpiration(String token){
        System.out.println("DENTRO DE EXTRACTExpiration= " + token);
        return extractClaim(token, Claims::getExpiration);
    }

    public String generateToken(String email){
        // Se crean las fechas de cuando comienza y cuando finaliza el token
        long timeExpiration = 24 * 60 * 60 * 1000; // 24 horas en milisegundos
        Date nowDate = new Date();
        Date dateExpiration = new Date(nowDate.getTime() + timeExpiration);

        return Jwts.builder()
                .subject(email)
                .issuedAt(nowDate)
                .expiration(dateExpiration)
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claim = extractAllClaims(token);
        System.out.println("DENTRO DE EXTRACTCLAIM: " + claim);
        return claimsResolver.apply(claim);
    }

    private Claims extractAllClaims(String token){
        System.out.println("DENTRO DE ALLCLAIMS= "+ token);
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
