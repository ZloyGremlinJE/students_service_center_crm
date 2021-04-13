package com.jm.students.util;

import com.jm.students.model.RequestType;
import com.jm.students.model.Role;
import com.jm.students.model.ServiceRequest;
import com.jm.students.model.User;
import com.jm.students.service.ServiceRequestService;
import com.jm.students.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@Profile("dev")
@Component
public class DevProfileSetup {

    private final UserService userService;
    private final ServiceRequestService serviceRequestService;
    private final EntityManager entityManager;

    @Autowired
    public DevProfileSetup(UserService userService, ServiceRequestService serviceRequestService
            , EntityManager entityManager) {

        this.userService = userService;
        this.serviceRequestService = serviceRequestService;
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void initDatabase() {

        if (entityManager.createQuery("select 1 from User")
                .setMaxResults(1).getResultList().isEmpty()
                && entityManager.createQuery("select 1 from ServiceRequest")
                .setMaxResults(1).getResultList().isEmpty()) {

            saveUser("directorName", "directorLastName"
                    , "director","director@mail.ru", Role.DIRECTOR);

            saveUser("managerName", "managerLastName"
                    , "manager","manager@mail.ru", Role.MANAGER);

            saveUser("engineerName", "engineerLastName"
                    , "engineer","engineer@mail.ru", Role.ENGINEER);

            User clientDirector = saveUser("clientDirectorName"
                    , "clientDirectorLastName"
                    , "clientDirector","client.director@mail.ru", Role.CLIENT_DIRECTOR);

            User clientEmployee = saveUser("clientEmployeeName"
                    , "clientEmployeeLastName"
                    , "clientEmployee","client.employee@mail.ru", Role.CLIENT_EMPLOYEE);


            saveServiceRequest("vehicleNumber1", LocalDate.now()
                    , RequestType.REQUEST_TYPE_1, "problem1"
                    , clientDirector);

            saveServiceRequest("vehicleNumber2", LocalDate.now()
                    , RequestType.REQUEST_TYPE_2, "problem2"
                    , clientEmployee);
        }
    }

    private User saveUser(String firstName, String lastName
            , String password, String email, Role role) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);

        userService.saveUser(user);
        return user;
    }

    private void saveServiceRequest(String vehicleNumber
            , LocalDate date, RequestType type, String problem, User customer) {

        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setVehicleNumber(vehicleNumber);
        serviceRequest.setDateOfCreate(date);
        serviceRequest.setRequestType(type);
        serviceRequest.setProblem(problem);
        serviceRequest.setCustomer(customer);

        serviceRequestService.saveServiceRequest(serviceRequest);
    }
}
