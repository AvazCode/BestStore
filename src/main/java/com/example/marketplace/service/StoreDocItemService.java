package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.StoreDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.StoreDocItemResDTO;

import java.util.List;

public interface StoreDocItemService {
    List<StoreDocItemResDTO> getALLStoreDocItem();
    StoreDocItemResDTO getStoreDocItemById(Long id);
    StoreDocItemResDTO createStoreDocItem(StoreDocItemReqDTO storeDocItemReqDTO);
    StoreDocItemResDTO updateStoreDocItem(Long id ,StoreDocItemReqDTO storeDocItemReqDTO);
    void deleteStoreDocItemById(Long id);
}
