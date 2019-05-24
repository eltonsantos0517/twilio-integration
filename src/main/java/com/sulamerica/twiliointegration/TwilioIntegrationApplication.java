package com.sulamerica.twiliointegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TwilioIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilioIntegrationApplication.class, args);
	}

}
