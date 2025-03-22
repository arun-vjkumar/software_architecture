package com.application.communications.service.client.sms;

import com.application.communications.config.TwilioConfig;
import com.application.communications.enums.Vendor;
import com.application.communications.service.SMSClientInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwilioClient implements SMSClientInterface {
    private final TwilioConfig twilioConfig;

    @Override
    public Vendor getVendor() {
        return Vendor.TWILIO;
    }

    @Override
    public void sendSMS() {
        // Implementation using Twilio API
        log.info("Sending SMS using Twilio with SID: {}", 
                twilioConfig.getAccountSid() != null ? "CONFIGURED" : "NOT CONFIGURED");
        // Further implementation would use the Twilio Java library
    }
}
