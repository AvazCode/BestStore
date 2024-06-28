package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.StoreDocReqDTO;
import com.example.marketplace.entity.StoreDoc;
import com.example.marketplace.repostory.ProductRepostory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface StoreDocReqMapper extends CommonMapper<StoreDocReqDTO, StoreDoc>{

}
