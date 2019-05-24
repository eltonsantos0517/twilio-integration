package com.sulamerica.twiliointegration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/email")
public class EmailController {

    private MailGunGateway mailGunGateway;

    public EmailController(MailGunGateway mailGunGateway) {
        this.mailGunGateway = mailGunGateway;
    }

    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void send(@RequestBody EmailBody body) {
        mailGunGateway.send(body.getFrom(), body.getTo(), body.getSubject(), body.getText());

    }
}
