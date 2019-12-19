package com.camunda.bpm.servicesdemo.services.impl;

import com.camunda.bpm.servicesdemo.config.EmailServiceConfig;
import com.camunda.bpm.servicesdemo.model.notification.Email;
import com.camunda.bpm.servicesdemo.util.PropertyNames;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final EmailServiceConfig emailServiceConfig;

    public List<Email> sendBatch(List<Email> emails) {
        List<Email> sentEmails = new ArrayList<>();
        emails.forEach(email -> {
            if(send(email))
                email.setSent(true);
                sentEmails.add(email);
        });
        return sentEmails;
    }

    public boolean send(Email email){
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(email.getTo());
            helper.setText(email.getContent(), true);
            helper.setSubject(email.getSubject());
            helper.setFrom(emailServiceConfig.getFromAddress());
            emailSender.send(message);
            return true;
        }
        catch(MessagingException e){
            return false;
        }
    }
}
