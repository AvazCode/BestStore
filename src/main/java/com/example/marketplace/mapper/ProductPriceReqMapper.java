package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.ProductPriceReqDTO;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ProductPrice;
import com.example.marketplace.repostory.ProductRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductPriceReqMapper implements CommonMapper<ProductPriceReqDTO, ProductPrice>{
    @Autowired
    ProductRepostory productRepostory;

    @Mapping(target = "product", expression = "java(findProductById(productPriceReqDTO.getProduct_id()))")
    public  abstract ProductPrice toENTITY(ProductPriceReqDTO productPriceReqDTO);


    protected Product findProductById(Long id){
        return productRepostory.findById(id).orElseThrow(()->new EntityNotFoundException("No found product"));
    }
}
