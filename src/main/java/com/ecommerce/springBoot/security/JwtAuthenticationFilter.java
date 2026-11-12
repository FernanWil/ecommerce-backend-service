package com.ecommerce.springBoot.security;

import com.ecommerce.springBoot.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    // Spring inyecta automáticamente el Bean que creaste en ApplicationConfig aquí
    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService){
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Entro el dofilterInternal");
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authHeader.substring(7);
        System.out.println("JWT "+ jwt);
        String email = jwtService.extractUsername(jwt);
        System.out.println("EMAIL:  "+ email);

        // ¡ESTA ZONA DEBE ESTAR ACTIVA!
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Llama al Bean de tu ApplicationConfig para buscar en la base de datos
            System.out.println("EMAIL"+ email);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
            System.out.println("USERDETAIL: "+ userDetails);
            // Valida firmas y expiración
            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Autoriza oficialmente la petición en el contexto de Spring
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}