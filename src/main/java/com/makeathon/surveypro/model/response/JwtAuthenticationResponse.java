package com.makeathon.surveypro.model.response;

public class JwtAuthenticationResponse {

    private final String tokenType;
    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
        this.tokenType = "Bearer";
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getToken() {
        return token;
    }
}
