package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocReqDTO;
import com.example.marketplace.entity.ReturnWarwDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnWarwDocReqMapper extends CommonMapper<ReturnWarwDocReqDTO, ReturnWarwDoc>{
}
