package com.sulamerica.twiliointegration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mailGun", url = "${mailgun.domain_url}",
        configuration = MailGunFeignConfiguration.class)
public interface MailGunGateway {

    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    void send(@RequestParam("from") String from, @RequestParam("to") String to,
              @RequestParam("subject") String subject, @RequestParam("text") String text);

}
