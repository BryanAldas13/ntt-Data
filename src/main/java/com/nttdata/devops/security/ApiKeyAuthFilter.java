package com.nttdata.devops.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ApiKeyAuthFilter extends OncePerRequestFilter {
    private final String apiKey = "2f5ae96c-b558-4c7b-a590-a501ae1c3f6c";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // 🚀 Permitir acceso sin API Key a /health y /actuator/health
        if (path.equals("/health") || path.equals("/actuator/health")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 🛑 Validar la API Key solo si la URL no está excluida
        String requestApiKey = request.getHeader("X-Parse-REST-API-KEY");

        if (apiKey.equals(requestApiKey)) {
            SecurityContextHolder.getContext().setAuthentication(new ApiKeyAuthentication(apiKey));
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid API Key");
            return;
        }

        filterChain.doFilter(request, response);
    }

}
