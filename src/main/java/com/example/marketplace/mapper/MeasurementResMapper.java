package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.MeasurementResDTO;
import com.example.marketplace.entity.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeasurementResMapper extends CommonMapper<MeasurementResDTO, Measurement> {
    @Mapping(source = "id",target = "id")
    MeasurementResDTO toDTO(Measurement measurement);
}
