package com.jm.students;

import com.jm.students.model.organization.AbstractOrganization;
import com.jm.students.model.organization.ClientOrganization;
import com.jm.students.model.organization.ServiceCenterOrganization;
import com.jm.students.service.AbstractOrganizationService;
import com.jm.students.service.AbstractOrganizationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServiceCenterCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCenterCrmApplication.class, args);
    }

}
