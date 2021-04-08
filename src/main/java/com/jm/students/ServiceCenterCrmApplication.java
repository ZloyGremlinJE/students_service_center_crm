package com.jm.students;


import com.jm.students.service.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class ServiceCenterCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCenterCrmApplication.class, args);
	}

}
