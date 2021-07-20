package com.pala.memsource.memsource.client;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import com.pala.memsource.memsource.auth.MemSourceAuthManager;
import com.pala.memsource.memsource.client.domain.MemSourceAuthRequest;
import com.pala.memsource.memsource.client.domain.MemSourceAuthResponse;
import com.pala.memsource.memsource.client.domain.MemSourceListOfProjectResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Class for calling MemSource API.
 */
@Component
public class MemSourceRestClient {
    private static final String DUMMY_URL = "dummyURL";

    private final static Logger LOGGER = Logger.getLogger(MemSourceRestClient.class.getName());

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${memsource.auth.url:dummyURL}")
    private String memSourceAuthUrl;

    @Value("${memsource.project.list.url:dummyURL}")
    private String memSourceProjectListUrl;

    @Autowired
    private MemSourceAuthManager memSourceAuthManager;

    @PostConstruct
    public void init() {
        if (DUMMY_URL.equals(memSourceAuthUrl) || DUMMY_URL.equals(memSourceProjectListUrl)) {
            throw new IllegalArgumentException("Wrong URL format");
        }
    }

    /**
     * Returns authorization token for input username and password.
     * Calls MemSource API for obtain token.
     * 
     * @param username Input username
     * @param password Input password
     * @return Authorization token for input username.
     */
    public MemSourceAuthResponse getAuthToken(String username, String password) {
        MemSourceAuthRequest memSourceAuthRequest = new MemSourceAuthRequest();
        memSourceAuthRequest.setUserName(username);
        memSourceAuthRequest.setPassword(password);

        LOGGER.info("Calling MemSource Auth API: username: " + username);
        
        ResponseEntity<MemSourceAuthResponse> response = 
            restTemplate.postForEntity(memSourceAuthUrl, memSourceAuthRequest, MemSourceAuthResponse.class); 
        
            LOGGER.info("MemSource Auth API Response: " + response.getStatusCodeValue());
            LOGGER.info("MemSource Auth API Response - token expires at: " + response.getBody().getExpires());

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }

        return null;
    }

    /**
     * Returns collection of project from MemSource API.
     * 
     * @param username Input username
     * @param password Input password
     * @return Collection of projects.
     */
    public MemSourceListOfProjectResponse getMemsourceProjectList(String username, String password) {
        // get auth token
        String authToken = memSourceAuthManager.getAuthToken(username, password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "ApiToken " + authToken);

        HttpEntity request = new HttpEntity(headers);
        
        ResponseEntity<MemSourceListOfProjectResponse> response = 
            restTemplate.exchange(memSourceProjectListUrl, HttpMethod.GET, request, MemSourceListOfProjectResponse.class);
        
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }

        return null;
    }

}
