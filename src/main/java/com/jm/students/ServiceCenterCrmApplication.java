package com.jm.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class ServiceCenterCrmApplication {
	@Autowired
	JavaMailSender mailSender;

	public static void main(String[] args) {

		SpringApplication.run(ServiceCenterCrmApplication.class, args);
	}

}
