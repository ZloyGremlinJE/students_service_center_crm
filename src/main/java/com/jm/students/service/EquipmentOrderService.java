package com.jm.students.service;

import com.jm.students.model.EquipmentOrder;

import java.util.List;

public interface EquipmentOrderService {
    List<EquipmentOrder> getAllEquipmentOrders();
    void saveEquipmentOrder(EquipmentOrder order);
    void updateEquipmentOrder(EquipmentOrder order);
    void deleteEquipmentOrder(EquipmentOrder order);
    EquipmentOrder getEquipmentOrderById(long id);
}
