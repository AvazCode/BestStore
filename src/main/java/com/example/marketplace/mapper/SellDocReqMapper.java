package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.SellDocReqDTO;
import com.example.marketplace.entity.SellDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellDocReqMapper extends CommonMapper<SellDocReqDTO, SellDoc>{
}
