package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.StoreProductReqDTO;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.StoreProduct;
import com.example.marketplace.repostory.ProductRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreProductReqMapper implements CommonMapper<StoreProductReqDTO,StoreProduct>{
    @Autowired
    private ProductRepostory productRepostory;

    @Mapping(target = "product",expression = "java(findProductById(storeProductReqDTO.getProduct_id()))")
    public abstract StoreProduct toENTITY(StoreProductReqDTO storeProductReqDTO);


    public Product findProductById(Long product_id){
        return productRepostory.findById(product_id).orElseThrow(()-> new EntityNotFoundException("NOT FOUND PRODUCT"));
    }
}
