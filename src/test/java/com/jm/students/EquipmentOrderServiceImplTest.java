package com.jm.students;

import com.jm.students.model.EquipmentOrder;
import com.jm.students.model.EquipmentType;
import com.jm.students.model.ServiceRequest;
import com.jm.students.service.EquipmentOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EquipmentOrderServiceImplTest {

    @Autowired
    private EquipmentOrderService equipmentOrderService;



    @Test
    void saveEquipmentOrder() {

        EquipmentOrder order1 = new EquipmentOrder(EquipmentType.EQUIPMENT_TYPE_1, "test1", 100);
        EquipmentOrder order2 = new EquipmentOrder(EquipmentType.EQUIPMENT_TYPE_1, "test2", 200);
        EquipmentOrder order3 = new EquipmentOrder(EquipmentType.EQUIPMENT_TYPE_1, "test3", 300);
        EquipmentOrder order4 = new EquipmentOrder(EquipmentType.EQUIPMENT_TYPE_1, "test4", 400);
        equipmentOrderService.saveEquipmentOrder(order1);
        equipmentOrderService.saveEquipmentOrder(order2);
        equipmentOrderService.saveEquipmentOrder(order3);
        equipmentOrderService.saveEquipmentOrder(order4);
        assertNotNull(equipmentOrderService.getEquipmentOrderById(1L));
        assertNotNull(equipmentOrderService.getEquipmentOrderById(2L));
        assertNotNull(equipmentOrderService.getEquipmentOrderById(3L));
        assertNotNull(equipmentOrderService.getEquipmentOrderById(4L));
        List<EquipmentOrder> orders = equipmentOrderService.getAllEquipmentOrders();
        assertEquals(4L, orders.size());

    }

    @Test
    void getAllEquipmentOrders() {
        List<EquipmentOrder> equipmentOrders = equipmentOrderService.getAllEquipmentOrders();
        assertNotNull(equipmentOrders);
        assertEquals(4L, equipmentOrders.size());
        equipmentOrders.forEach(System.out::println);

    }

    @Test
    void updateEquipmentOrder() {

        EquipmentOrder order = equipmentOrderService.getEquipmentOrderById(1L);
        order.setEquipmentType(EquipmentType.EQUIPMENT_TYPE_2);
        order.setEquipmentName("test5");
        order.setPrice(500);
        equipmentOrderService.updateEquipmentOrder(order);
        String test = "test5";
        String real = equipmentOrderService.getEquipmentOrderById(1L).getEquipmentName();
        assertEquals(test, real);
    }
    @Test
    void getEquipmentOrderById() {
        Long a = 1L;
        Long b = equipmentOrderService.getEquipmentOrderById(1L).getId();
        System.out.println(b);
        assertEquals(a, b);
    }

    @Test
    void deleteEquipmentOrder() {
        EquipmentOrder order = equipmentOrderService.getEquipmentOrderById(2L);
        equipmentOrderService.deleteEquipmentOrder(order);
        List<EquipmentOrder> orderList = equipmentOrderService.getAllEquipmentOrders();
        assertEquals(3L, orderList.size());
        orderList.forEach(System.out::println);
    }

}