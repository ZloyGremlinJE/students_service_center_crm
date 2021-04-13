package com.jm.students.repository;

import com.jm.students.model.EquipmentOrder;

import java.util.List;

public interface EquipmentOrderRepository {
    List<EquipmentOrder> getAllEquipmentOrders();
    void saveEquipmentOrder(EquipmentOrder order);
    void updateEquipmentOrder(EquipmentOrder order);
    void deleteEquipmentOrder(EquipmentOrder order);
    EquipmentOrder getEquipmentOrderById(long id);
    void deleteEquipmentOrderById(Long id);
}
