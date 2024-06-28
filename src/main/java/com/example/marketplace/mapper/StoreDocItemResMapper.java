package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.StoreDocItemResDTO;
import com.example.marketplace.dto.responseDTO.StoreDocResDTO;
import com.example.marketplace.entity.StoreDoc;
import com.example.marketplace.entity.StoreDocItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StoreDocItemResMapper extends CommonMapper<StoreDocItemResDTO, StoreDocItem>{
    @Mapping(source = "product",target = "productResDTO")
    @Mapping(source = "storeDoc",target = "storeDocResDTO")
    StoreDocItemResDTO toDTO(StoreDocItem storeDocItem);
}
