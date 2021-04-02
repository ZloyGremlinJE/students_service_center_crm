package com.jm.students.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipment_orders")
public class EquipmentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "equipment_type")
    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "price")
    private int price;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "service_request_id")
    private ServiceRequest request;
}
