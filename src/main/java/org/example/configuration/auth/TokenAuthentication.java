package org.example.configuration.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class TokenAuthentication extends AbstractAuthenticationToken {
    private final String token;

    public TokenAuthentication(String token) {
        super(Collections.emptyList());
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}
