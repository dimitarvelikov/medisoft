package com.medisoft.nzis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class NzisAuthService {

    private static final long AUTH_TOKEN_EXPIRATION_OFFSET_SECONDS = 10;
    private String token;
    private LocalDateTime expiresOn;

    private final NzisConfig config;


    public String getToken() {
        if (isExpired()) {
            authenticate();
        }

        return token;
    }

    /**
     * AUTH_TOKEN_EXPIRATION_OFFSET_SECONDS is used to cover the difference between LocalDateTime.now()
     * and the actual time when the request will be received by NZIS.
     */
    private boolean isExpired() {
        return expiresOn == null || expiresOn.isBefore(LocalDateTime.now().plusSeconds(AUTH_TOKEN_EXPIRATION_OFFSET_SECONDS));
    }

    private void authenticate() {
        ResponseEntity<String> result = new RestTemplate().getForEntity(config.getAuthUrl() + "/token", String.class);

        if (result.getStatusCode().is2xxSuccessful()) {
            String body = result.getBody();
            /*
            // todo convert xml to json, or extract needed values via extraction of expected output:

            <?xml version="1.1" encoding="UTF-8"?>
<nhis:message xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:nhis="https://www.his.bg" xsi:schemaLocation="https://www.his.bg
https://www.his.bg/api/v1/NHIS-S001.xsd">
 <nhis:contents>
 <nhis:accessToken value="imSXTs2OqSrGWzsF3rF..." dataType="[string]"/>
 <nhis:tokenType value="bearer" dataType="[string]"/>
 <nhis:expiresIn value="7200" dataType="[positiveInt]"/>
 <nhis:issuedOn value="2020-10-21T18:11:23" dataType="[dateTime]"/>
 <nhis:expiresOn value="2020-10-21T18:13:23" dataType="[dateTime]"/>
 </nhis:contents>
</nhis:message>
             */


        }

        throw new IllegalStateException("Could not authenticate. NZIS Status code: " + result.getStatusCode().value());
    }
}
