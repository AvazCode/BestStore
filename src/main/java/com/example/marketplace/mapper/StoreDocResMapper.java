package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.StoreDocReqDTO;
import com.example.marketplace.dto.responseDTO.StoreDocResDTO;
import com.example.marketplace.entity.StoreDoc;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface StoreDocResMapper extends CommonMapper<StoreDocResDTO, StoreDoc>{

}
