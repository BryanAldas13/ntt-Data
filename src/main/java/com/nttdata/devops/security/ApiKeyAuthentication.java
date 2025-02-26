package com.nttdata.devops.security;

import org.springframework.security.core.Authentication;

public class ApiKeyAuthentication implements Authentication {

    private final String apiKey;

    public ApiKeyAuthentication(String apiKey){
        this.apiKey = apiKey;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return apiKey;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

    @Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return null;
    }

}
