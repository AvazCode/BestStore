package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.StoreProductReqDTO;
import com.example.marketplace.dto.responseDTO.StoreProductResDTO;
import com.example.marketplace.entity.StoreProduct;
import com.example.marketplace.mapper.StoreProductReqMapper;
import com.example.marketplace.mapper.StoreProductResMapper;
import com.example.marketplace.mapper.StoreProductReqMapper;
import com.example.marketplace.mapper.StoreProductResMapper;
import com.example.marketplace.repostory.*;
import com.example.marketplace.repostory.StoreProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreProductServiceImpl implements StoreProductService{
    private final StoreProductReqMapper storeProductReqMapper;
    private final StoreProductResMapper storeProductResMapper;
    private final StoreProductRepostory storeProductRepostory;
    private final ProductRepostory productRepostory;
    @Override
    public List<StoreProductResDTO> getALLStoreProduct() {
        return storeProductResMapper.toDTOs(storeProductRepostory.findAll());
    }

    @Override
    public StoreProductResDTO getStoreProductById(Long id) {
        return storeProductResMapper.toDTO(storeProductRepostory.getReferenceById(id));
    }

    @Override
    public StoreProductResDTO createStoreProduct(StoreProductReqDTO storeProductReqDTO) {

        return storeProductResMapper.toDTO(storeProductRepostory.save(storeProductReqMapper.toENTITY(storeProductReqDTO)));
    }

    @Override
    public StoreProductResDTO updateStoreProduct(Long id, StoreProductReqDTO storeProductReqDTO) {
        StoreProduct storeProduct = storeProductRepostory.getReferenceById(id);
        storeProduct.setAmount(storeProductReqDTO.getAmount());
        storeProduct.setProduct(productRepostory.getReferenceById(storeProductReqDTO.getProduct_id()));
        return storeProductResMapper.toDTO(storeProductRepostory.save(storeProduct));
    }

    @Override
    public void deleteStoreProductById(Long id) {
        storeProductRepostory.deleteById(id);
    }
}
