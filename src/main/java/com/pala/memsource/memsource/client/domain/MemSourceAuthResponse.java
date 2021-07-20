package com.pala.memsource.memsource.client.domain;

import java.time.OffsetDateTime;

public class MemSourceAuthResponse {
    
    private MemSourceUser user;

    private String token;

    private OffsetDateTime expires;

    public MemSourceAuthResponse() { }

    public MemSourceAuthResponse(MemSourceUser user, String token, OffsetDateTime expires) {
        this.user = user;
        this.token = token;
        this.expires = expires;
    }

    public MemSourceUser getUser() {
        return user;
    }

    public void setUser(MemSourceUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public OffsetDateTime getExpires() {
        return expires;
    }

    public void setExpires(OffsetDateTime expires) {
        this.expires = expires;
    }

}
