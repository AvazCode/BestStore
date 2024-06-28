package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.StoreProductReqDTO;
import com.example.marketplace.dto.responseDTO.StoreProductResDTO;

import java.util.List;

public interface StoreProductService {
    List<StoreProductResDTO> getALLStoreProduct();
    StoreProductResDTO getStoreProductById(Long id);
    StoreProductResDTO createStoreProduct(StoreProductReqDTO storeProductReqDTO);
    StoreProductResDTO updateStoreProduct(Long id ,StoreProductReqDTO storeProductReqDTO);
    void deleteStoreProductById(Long id);
}
