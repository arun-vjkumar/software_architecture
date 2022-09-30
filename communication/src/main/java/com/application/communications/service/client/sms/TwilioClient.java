package com.application.communications.service.client.sms;

import com.application.communications.config.TwilioConfig;
import com.application.communications.enums.Vendor;
import com.application.communications.service.SMSClientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    }
}
