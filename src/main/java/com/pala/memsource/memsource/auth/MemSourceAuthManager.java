package com.pala.memsource.memsource.auth;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.pala.memsource.memsource.client.MemSourceRestClient;
import com.pala.memsource.memsource.client.domain.MemSourceAuthResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class for storing auth tokens to MemSource API.
 */
@Component
public class MemSourceAuthManager {
    
    private final static Logger LOGGER = Logger.getLogger(MemSourceAuthManager.class.getName());
    
    /**
     * Cache for auth tokens.
     * Key - username
     * Value - auth token and his expiration date
     */
    private Map<String, MemSourceAuthResponse> authTokenMap = new HashMap<>();

    @Autowired
    private MemSourceRestClient memSourceRestClient;

    /**
     * Returns authorization token for input username and password.
     * Calls MemSource API for obtain token.
     * 
     * @param username Input username
     * @param password Input password
     * @return Authorization token for input username.
     */
    public String getAuthToken(String username, String password) {
        if ( !authTokenMap.containsKey(username) || 
            ( authTokenMap.containsKey(username) && authTokenMap.get(username).getExpires().isBefore(OffsetDateTime.now()) ) 
        ) {
            // token for current username doesn't exists
            // or token is expired
            // => we will get new token for current user
            LOGGER.info("MemSourceAuthManager doesn't contains token for username: " + username);
            MemSourceAuthResponse memSourceAuthResponse = memSourceRestClient.getAuthToken(username, password);

            if (!authTokenMap.containsKey(username)) {
                authTokenMap.put(username, memSourceAuthResponse);
            } else {
                authTokenMap.get(username).setToken(memSourceAuthResponse.getToken());
                authTokenMap.get(username).setExpires(memSourceAuthResponse.getExpires());
            }
        }

        return authTokenMap.get(username).getToken();       
    }

}
