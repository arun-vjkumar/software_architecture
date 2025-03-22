package com.application.communications.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;


@Getter
@Configuration
@ConfigurationProperties(prefix = "")
public class FirebaseConfig {
    private String apiKey;
    private String projectId;
    private String messagingSenderId;
    private String appId;
    private String serverKey;
}
