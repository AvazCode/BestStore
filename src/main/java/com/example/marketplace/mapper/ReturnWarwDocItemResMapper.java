package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.ReturnWarwDocItemResDTO;
import com.example.marketplace.entity.ReturnWarwDocItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReturnWarwDocItemResMapper extends CommonMapper<ReturnWarwDocItemResDTO, ReturnWarwDocItem>{
    @Mapping(source = "returnWarwDoc",target = "returnWarwDocResDTO")
    @Mapping(source = "storeProduct",target = "storeProductResDTO")
    @Mapping(source = "product",target = "productResDTO")
    ReturnWarwDocItemResDTO toDTO(ReturnWarwDocItem returnWarwDocItem);
}
