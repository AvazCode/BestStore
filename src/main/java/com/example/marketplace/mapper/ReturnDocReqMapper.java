package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.ReturnDocReqDTO;
import com.example.marketplace.entity.ReturnDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnDocReqMapper extends CommonMapper<ReturnDocReqDTO, ReturnDoc>{
}
