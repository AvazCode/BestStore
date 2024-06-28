package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.SellDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.SellDocItemResDTO;

import java.util.List;

public interface SellDocItemService {
    List<SellDocItemResDTO> getALLSellDocItem();
    SellDocItemResDTO getSellDocItemById(Long id);
    SellDocItemResDTO createSellDocItem(SellDocItemReqDTO sellDocReqDTO);
    SellDocItemResDTO updateSellDocItem(Long id ,SellDocItemReqDTO sellDocReqDTO);
    void deleteSellDocItemById(Long id);
}
