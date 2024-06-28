package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.ReturnDocResDTO;
import com.example.marketplace.entity.ReturnDoc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReturnDocResMapper extends CommonMapper<ReturnDocResDTO, ReturnDoc>{

}
