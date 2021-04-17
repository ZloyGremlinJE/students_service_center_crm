package com.jm.students.model;

import com.jm.students.model.organization.AbstractOrganization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private AbstractOrganization organization;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    List<ServiceRequest> requestList = new ArrayList<>();

    public void addNewServiceRequest(ServiceRequest request) {
        requestList.add(request);
        request.setCustomer(this);
    }

    public void removeServiceRequest(ServiceRequest request) {
        requestList.remove(request);
        request.setCustomer(null);
    }


    private String telegramChatId;

    @Override
    public String toString() {
        return "работник сервиса : " +
                " имя : " + firstName + '\'' +
                " фамилия : " + lastName + '\'' +
                " должность : " + role;
    }
}
