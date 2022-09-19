package com.application.communications.service.client.email;

import com.application.communications.config.SendGridConfig;
import com.application.communications.service.EmailClientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendGrid implements EmailClientInterface {
    private final SendGridConfig sendGridConfig;

    @Override
    public String getVendor() {
        return "SendGrid";
    }

    @Override
    public void sendMail() {
    }
}
