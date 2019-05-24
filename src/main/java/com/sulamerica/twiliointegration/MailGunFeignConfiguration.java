package com.sulamerica.twiliointegration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailGunFeignConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(@Value("${mailgun.token}") String token) {
        return new BasicAuthRequestInterceptor("api", token);
    }
}
