package com.jm.students.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "date_of_create")
    private LocalDate dateOfCreate;

    @Column(name = "request_type")
    @Enumerated(EnumType.STRING)
    private RequestType requestType;

    @Column(name = "problem")
    private String problem;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "client_employee_id")
    private ClientEmployee customer;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "request")
    private List<EquipmentOrder> orders;

    public void AddNewEquipmentOrder(EquipmentOrder order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setRequest(this);
    }
}
