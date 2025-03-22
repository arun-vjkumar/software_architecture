package com.application.communications.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "sendgrid")
public class SendGridConfig {
    private String apiKey;
    private String fromEmail;
    private String fromName;
    private String templateId;
    private String sandboxMode;
}
