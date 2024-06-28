package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.SellDocResDTO;
import com.example.marketplace.entity.SellDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellDocResMapper extends CommonMapper<SellDocResDTO, SellDoc>{
}
