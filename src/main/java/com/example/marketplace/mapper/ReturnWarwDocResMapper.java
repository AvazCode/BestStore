package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.ReturnWarwDocResDTO;
import com.example.marketplace.entity.ReturnWarwDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnWarwDocResMapper extends CommonMapper<ReturnWarwDocResDTO, ReturnWarwDoc>{
}
