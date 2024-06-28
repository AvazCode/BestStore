package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.CompanyReqDTO;
import com.example.marketplace.dto.responseDTO.CompanyResDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyResDTO> getALLCompany();
    CompanyResDTO getCompanyById(Long id);
    CompanyResDTO createCompany(CompanyReqDTO companyReqDTO);
    CompanyResDTO updateCompany(Long id ,CompanyReqDTO companyReqDTO);
    void deleteCompanyById(Long id);
}
