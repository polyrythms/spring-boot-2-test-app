package org.example.configuration.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class TokenAuthentication extends AbstractAuthenticationToken {
    private String token;

    public TokenAuthentication(String token) {
        super(Collections.emptyList());
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
