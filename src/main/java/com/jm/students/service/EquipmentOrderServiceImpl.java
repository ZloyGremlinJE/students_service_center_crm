package com.jm.students.service;

import com.jm.students.model.EquipmentOrder;
import com.jm.students.model.ServiceRequest;
import com.jm.students.repository.EquipmentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EquipmentOrderServiceImpl implements EquipmentOrderService {

    private final EquipmentOrderRepository orderRepository;

    @Autowired
    public EquipmentOrderServiceImpl(EquipmentOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<EquipmentOrder> getAllEquipmentOrders() {
        return orderRepository.getAllEquipmentOrders();
    }

    @Override
    public void saveEquipmentOrder(EquipmentOrder order) {
        ServiceRequest request = order.getRequest();
        request.addNewEquipmentOrder(order);

        orderRepository.saveEquipmentOrder(order);
    }

    @Override
    public void updateEquipmentOrder(EquipmentOrder order) {
        orderRepository.updateEquipmentOrder(order);
    }

    @Override
    public void deleteEquipmentOrder(EquipmentOrder order) {
        ServiceRequest request = order.getRequest();
        request.removeEquipmentOrder(order);

        orderRepository.deleteEquipmentOrder(order);
    }

    @Override
    public EquipmentOrder getEquipmentOrderById(long id) {
        return orderRepository.getEquipmentOrderById(id);
    }

    @Override
    public void deleteEquipmentOrderByID(Long id) {
        orderRepository.deleteEquipmentOrderById(id);
    }
}
