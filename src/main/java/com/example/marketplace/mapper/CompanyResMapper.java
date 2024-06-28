package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.CompanyResDTO;
import com.example.marketplace.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyResMapper extends CommonMapper<CompanyResDTO, Company> {
    @Override
    CompanyResDTO toDTO(Company company);
}
