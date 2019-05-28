package com.sulamerica.twiliointegration;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/v1/call")
public class CallController {

    public CallController(@Value("${twilio.account_sid}") String accountSid,
                          @Value("${twilio.auth_token}") String authToken) {
        Twilio.init(accountSid, authToken);
    }

    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void send(@RequestBody CallBody body) throws URISyntaxException, IOException {
        Call call = Call.creator(new PhoneNumber(body.getNumberTo()), new PhoneNumber(body.getNumberFrom()),
                URI.create("http://q7817.mocklab.io/voice?message=" + URLEncoder.encode(body.getMessageBody(), "UTF-8")))
                .create();

        System.out.println(call.getSid());
    }
}
