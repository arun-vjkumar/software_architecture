package com.application.communications.service.client.email;

import com.application.communications.config.SendGridConfig;
import com.application.communications.enums.Vendor;
import com.application.communications.service.EmailClientInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendGridClient implements EmailClientInterface {
    private final SendGridConfig sendGridConfig;

    @Override
    public Vendor getVendor() {
        return Vendor.SEND_GRID;
    }

    @Override
    public void sendMail() {
        // Implementation using SendGrid API
        log.info("Sending email using SendGrid with API key: {}", 
                sendGridConfig.getApiKey() != null ? "CONFIGURED" : "NOT CONFIGURED");
        // Further implementation would use the SendGrid Java library
    }
}
