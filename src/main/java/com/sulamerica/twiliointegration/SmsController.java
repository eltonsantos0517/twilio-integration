package com.sulamerica.twiliointegration;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sms")
public class SmsController {

    public SmsController(@Value("${twilio.account_sid}") String accountSid,
                         @Value("${twilio.auth_token}") String authToken) {
        Twilio.init(accountSid, authToken);
    }

    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void send(@RequestBody SmsBody body) {

        Message message = Message.creator(new PhoneNumber(body.getNumberTo()),
                new PhoneNumber(body.getNumberFrom()),
                body.getMessageBody()).create();

        System.out.println(message.getSid());
    }
}
