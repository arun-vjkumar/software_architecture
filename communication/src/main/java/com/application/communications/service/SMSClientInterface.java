package com.application.communications.service;

import com.application.communications.enums.Vendor;

public interface SMSClientInterface {
    Vendor getVendor();
    void sendSMS();
}
