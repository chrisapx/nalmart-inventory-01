package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailSenderService {
    void sendEmail(String to,String subject,String message) throws MessagingException, UnsupportedEncodingException;
}
