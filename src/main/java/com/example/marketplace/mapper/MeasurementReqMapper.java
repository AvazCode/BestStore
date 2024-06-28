package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.MeasurementReqDTO;
import com.example.marketplace.entity.Measurement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementReqMapper extends CommonMapper<MeasurementReqDTO, Measurement>{
}
