package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.DocItemsResDTO;
import com.example.marketplace.entity.DocItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocItemsResMapper extends CommonMapper<DocItemsResDTO, DocItems>{
    @Mapping(source = "document",target = "documentResDTO")
    @Mapping(source = "product",target = "productResDTO")
    DocItemsResDTO toDTO(DocItems docItems);
}
