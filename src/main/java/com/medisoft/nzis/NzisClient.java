package com.medisoft.nzis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class NzisClient {

    private final NzisConfig config;
    private final NzisAuthService nzisAuthService;


    private ResponseEntity<String> post(String endpoint, String xmlBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(nzisAuthService.getToken());

        HttpEntity<String> entity = new HttpEntity<>(xmlBody, headers);

        return new RestTemplate().exchange(config.getApiUrl() + endpoint, HttpMethod.POST, entity, String.class);
    }

}
