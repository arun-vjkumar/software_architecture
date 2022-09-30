package com.application.communications.service;

import com.application.communications.enums.Vendor;

public interface NotificationClientInterface {
    Vendor getVendor();

    void sendNotification();
}
