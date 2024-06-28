package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.SellDocReqDTO;
import com.example.marketplace.dto.responseDTO.SellDocResDTO;

import java.util.List;

public interface SellDocService {
    List<SellDocResDTO> getALLSellDoc();
    SellDocResDTO getSellDocById(Long id);
    SellDocResDTO createSellDoc(SellDocReqDTO sellDocReqDTO);
    SellDocResDTO updateSellDoc(Long id ,SellDocReqDTO sellDocReqDTO);
    void deleteSellDocById(Long id);
}
