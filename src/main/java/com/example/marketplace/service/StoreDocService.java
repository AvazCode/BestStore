package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.StoreDocReqDTO;
import com.example.marketplace.dto.responseDTO.StoreDocResDTO;

import java.util.List;

public interface StoreDocService {
    List<StoreDocResDTO> getALLStoreDoc();
    StoreDocResDTO getStoreDocById(Long id);
    StoreDocResDTO createStoreDoc(StoreDocReqDTO storeDocReqDTO);
    StoreDocResDTO updateStoreDoc(Long id ,StoreDocReqDTO storeDocReqDTO);
    void deleteStoreDocById(Long id);
}
