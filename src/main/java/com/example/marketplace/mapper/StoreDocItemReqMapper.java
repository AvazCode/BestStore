package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.StoreDocItemReqDTO;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.StoreDoc;
import com.example.marketplace.entity.StoreDocItem;
import com.example.marketplace.repostory.ProductRepostory;
import com.example.marketplace.repostory.StoreDocRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreDocItemReqMapper implements CommonMapper<StoreDocItemReqDTO, StoreDocItem>{
    @Autowired
    private ProductRepostory productRepostory;
    @Autowired
    private StoreDocRepostory storeDocRepostory;

    @Mapping(target = "product",expression = "java(findProductById(storeDocItemReqDTO.getProduct_id()))")
    @Mapping(target = "storeDoc",expression = "java(findStoreDocById(storeDocItemReqDTO.getStoreDoc_id()))")
    public abstract StoreDocItem toENTITY(StoreDocItemReqDTO storeDocItemReqDTO);

    public Product findProductById(Long product_id){
        return productRepostory.findById(product_id).orElseThrow(()-> new EntityNotFoundException("NOT FOUND PRODUCT"));
    }
    public StoreDoc findStoreDocById(Long storeDoc_id){
        return storeDocRepostory.findById(storeDoc_id).orElseThrow(()-> new EntityNotFoundException("NOT FOUND STORE DOC"));
    }
}
