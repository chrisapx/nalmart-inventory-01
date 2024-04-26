package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Slf4j
@Service
public class EmailSenderServiceimpl implements EmailSenderService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine; // Inject the TemplateEngine

    @Autowired
    public EmailSenderServiceimpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(String to, String subject, String message) throws MessagingException, UnsupportedEncodingException {
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);

            helper.setTo(to);
            helper.setFrom("nalmartinc@gmail.com", "Nalmart Support");
            helper.setSubject(subject);
            helper.setSentDate(new Date());
            helper.setText ( message +
                    "\n\nRegards" +
                    "\nNalmart Support\n" +
                    "nalmartinc@gmail.com | info@nalmart.com | (256)758085749" +
                    "\nNalmart Inc | nalmart.com");

            // Load the HTML template
//            Context context = new Context();
//            context.setVariable("message", message); // Pass message to the template
//            String emailBody = templateEngine.process("custom-email-template", context); // Load and process the HTML template

//            helper.setText(emailBody, false); // Set the email body as HTML or not

            mailSender.send(mail);

            log.info("{} forwarded to {}", subject, to);
        } catch (Exception e) {
            log.info("Sending an email to {} failed : {}", to, e.getLocalizedMessage());
            throw e;
        }
    }


}
