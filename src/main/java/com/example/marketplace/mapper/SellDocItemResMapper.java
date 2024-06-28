package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.SellDocItemResDTO;
import com.example.marketplace.entity.SellDocItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SellDocItemResMapper extends CommonMapper<SellDocItemResDTO,SellDocItem>{
    @Mapping(source = "storeProduct",target = "storeProductResDTO")
    @Mapping(source = "sellDoc",target = "sellDocResDTO")
    SellDocItemResDTO toDTO(SellDocItem sellDocItem);
}
