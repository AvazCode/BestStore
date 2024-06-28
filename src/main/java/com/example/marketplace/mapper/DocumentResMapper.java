package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.DocumentResDTO;
import com.example.marketplace.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentResMapper extends CommonMapper<DocumentResDTO, Document>{
    @Mapping(source = "company",target = "companyResDTO")
    DocumentResDTO toDTO(Document document);
}
