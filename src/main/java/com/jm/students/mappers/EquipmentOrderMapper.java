package com.jm.students.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentOrderMapper {

    EquipmentOrderMapper EQUIPMENT_ORDER_MAPPER = Mappers.getMapper(EquipmentOrderMapper.class);
}
