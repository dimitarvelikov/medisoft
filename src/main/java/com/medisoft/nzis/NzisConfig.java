package com.medisoft.nzis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "nzis")
public class NzisConfig {

    private String apiUrl;
    private String authUrl;

}
