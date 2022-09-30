package com.application.communications.service;

import com.application.communications.enums.Vendor;

public interface EmailClientInterface {
    Vendor getVendor();

    void sendMail();
}
