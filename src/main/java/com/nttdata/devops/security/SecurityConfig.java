package com.nttdata.devops.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Desactiva CSRF (opcional)
                .addFilterBefore(new ApiKeyAuthFilter(), UsernamePasswordAuthenticationFilter.class) // Añade filtro personalizado
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/health", "/actuator/health").permitAll() // Permite acceso libre a la Readiness Probe
                        .requestMatchers("/DevOps").authenticated() // Protege solo /DevOps
                        .anyRequest().permitAll() // Permite acceso a otros endpoints sin autenticación
                );

        return http.build();
    }

}
