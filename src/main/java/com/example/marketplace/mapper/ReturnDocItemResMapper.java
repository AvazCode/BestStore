package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.ReturnDocItemResDTO;
import com.example.marketplace.entity.ReturnDocItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReturnDocItemResMapper extends CommonMapper<ReturnDocItemResDTO,ReturnDocItem> {
    @Mapping(source = "returnDoc",target = "returnDocResDTO")
    @Mapping(source = "storeProduct",target = "storeProductResDTO")
    ReturnDocItemResDTO toDTO(ReturnDocItem returnDocItem);
}
