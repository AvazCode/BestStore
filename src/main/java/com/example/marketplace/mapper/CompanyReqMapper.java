package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.CompanyReqDTO;
import com.example.marketplace.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyReqMapper extends CommonMapper<CompanyReqDTO, Company>{

}
