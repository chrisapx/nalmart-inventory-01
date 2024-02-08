package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.model.EmailMessage;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.EmailSenderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/send")
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController( EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-email")
    @ApiOperation("Send an Email")
    public ResponseEntity<EmailMessage> sendEmail(@RequestBody EmailMessage emailMessage){
        try {
            emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @Autowired
//    TestEmailBody testEmailBody;
//    @GetMapping("/html")
//    public void sendHtmlMail(){
//        testEmailBody.sendCustomMail ( "mcaplexya@gmail.com", false,false,false,false );
//    }
}
