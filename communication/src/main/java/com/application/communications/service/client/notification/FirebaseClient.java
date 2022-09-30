package com.application.communications.service.client.notification;

import com.application.communications.config.FirebaseConfig;
import com.application.communications.enums.Vendor;
import com.application.communications.service.NotificationClientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FirebaseClient implements NotificationClientInterface {
    private final FirebaseConfig firebaseConfig;

    @Override
    public Vendor getVendor() {
        return Vendor.FIREBASE;
    }

    @Override
    public void sendNotification() {
    }
}
