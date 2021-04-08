package com.jm.students.controller.rest;

import com.jm.students.DTO.EquipmentOrderDTO;
import com.jm.students.mappers.EquipmentOrderMapper;
import com.jm.students.model.EquipmentOrder;
import com.jm.students.service.EquipmentOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipmentOrders")
public class EquipmentOrderREST {
    private final EquipmentOrderService equipmentOrderService;
    private final EquipmentOrderMapper equipmentOrderMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EquipmentOrderDTO getOneEquipmentOrder(@PathVariable Long id) {
        return equipmentOrderMapper.toEquipmentOrderDto(equipmentOrderService.getEquipmentOrderById(id));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentOrderDTO> getAllEquipmentOrders() {
        List<EquipmentOrder> listOfEquipments = equipmentOrderService.getAllEquipmentOrders();
        List<EquipmentOrderDTO> listOfEquipmentsDTO = new ArrayList<>();
        for (EquipmentOrder equipment : listOfEquipments) {
            listOfEquipmentsDTO.add(equipmentOrderMapper.toEquipmentOrderDto(equipment));
        }
        return listOfEquipmentsDTO;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEquipmentOrder(@RequestBody EquipmentOrder equipmentOrder) {
        equipmentOrderService.saveEquipmentOrder(equipmentOrder);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void updateEquipmentOrder(@RequestBody EquipmentOrder equipmentOrder) {
        equipmentOrderService.updateEquipmentOrder(equipmentOrder);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEquipmentOrder(@PathVariable Long id) {
        equipmentOrderService.deleteEquipmentOrderByID(id);
    }

}
