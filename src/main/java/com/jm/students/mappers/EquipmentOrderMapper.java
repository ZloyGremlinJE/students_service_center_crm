package com.jm.students.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EquipmentOrderMapper {

    EquipmentOrderMapper EQUIPMENT_ORDER_MAPPER = Mappers.getMapper(EquipmentOrderMapper.class);

    @Mapping(source = "equipmentType", target = "equipmentTypeDTO")
    @Mapping(source = "equipmentName", target = "equipmentName")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "request", target = "request")
    EquipmentOrderDTO toEquipmentOrderDto(EquipmentOrder order);
}
