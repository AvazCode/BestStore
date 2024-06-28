package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.StoreProductResDTO;
import com.example.marketplace.entity.StoreProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StoreProductResMapper extends CommonMapper<StoreProductResDTO, StoreProduct>{
    @Mapping(source = "product",target = "productResDTO")
    StoreProductResDTO toDTO(StoreProduct storeProduct);
}
