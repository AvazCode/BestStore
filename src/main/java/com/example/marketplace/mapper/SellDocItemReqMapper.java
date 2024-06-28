package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.SellDocItemReqDTO;
import com.example.marketplace.entity.SellDoc;
import com.example.marketplace.entity.SellDocItem;
import com.example.marketplace.entity.StoreProduct;
import com.example.marketplace.repostory.SellDocRepostory;
import com.example.marketplace.repostory.StoreProductRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SellDocItemReqMapper implements CommonMapper<SellDocItemReqDTO, SellDocItem>{
    @Autowired
    private StoreProductRepostory storeProductRepostory;
    @Autowired
    private SellDocRepostory sellDocRepostory;
    @Mapping(target = "storeProduct",expression = "java(findStoreProductById(sellDocItemReqDTO.getStoreProduct_id()))")
    @Mapping(target = "sellDoc",expression = "java(findSellDocById(sellDocItemReqDTO.getSellDoc_id()))")
    public abstract SellDocItem toENTITY(SellDocItemReqDTO sellDocItemReqDTO);

    public StoreProduct findStoreProductById(Long id){
        return storeProductRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("StoreProduct not found"));
    }

    public SellDoc findSellDocById(Long id){
        return sellDocRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("SellDoc not found"));
    }
}
