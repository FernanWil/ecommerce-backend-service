package com.ecommerce.springBoot;

import com.ecommerce.springBoot.user.domain.port.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    private final UserRepositoryPort userRepositoryPort;

    // Inyección por constructor de tu puerto
    public ApplicationConfig(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepositoryPort.findByEmail(username)
                .map(user -> org.springframework.security.core.userdetails.User.withUsername(user.email())
                        .password(user.passwordHash())
                        .authorities(new java.util.ArrayList<>())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email: " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        // DaoAuthenticationProvider de org.springframework.security.authentication.dao
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
        // Pasamos directamente la instancia inyectada en el parámetro del metodo
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}