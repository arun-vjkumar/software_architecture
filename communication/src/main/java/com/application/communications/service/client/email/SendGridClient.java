package com.application.communications.service.client.email;

import com.application.communications.config.SendGridConfig;
import com.application.communications.enums.Vendor;
import com.application.communications.service.EmailClientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
    }
}
