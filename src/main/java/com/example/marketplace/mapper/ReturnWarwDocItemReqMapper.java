package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocItemReqDTO;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ReturnWarwDoc;
import com.example.marketplace.entity.ReturnWarwDocItem;
import com.example.marketplace.entity.StoreProduct;
import com.example.marketplace.repostory.ProductRepostory;
import com.example.marketplace.repostory.ReturnWarwDocRepostory;
import com.example.marketplace.repostory.StoreProductRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReturnWarwDocItemReqMapper implements CommonMapper<ReturnWarwDocItemReqDTO,ReturnWarwDocItem>{
    @Autowired
    private ProductRepostory productRepostory;
    @Autowired
    private ReturnWarwDocRepostory returnWarwDocRepostory;
    @Autowired
    private StoreProductRepostory storeProductRepostory;
    @Mapping(target = "returnWarwDoc",expression = "java(findReturnWarwDocById(returnWarwDocItemReqDTO.getReturnWarwDoc_id()))")
    @Mapping(target = "storeProduct",expression = "java(findStoreProductById(returnWarwDocItemReqDTO.getStoreProduct_id()))")
    @Mapping(target = "product",expression = "java(findProductById(returnWarwDocItemReqDTO.getProduct_id()))")
    public abstract ReturnWarwDocItem toENTITY(ReturnWarwDocItemReqDTO returnWarwDocItemReqDTO);
    public Product findProductById(Long id){
        return productRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found"));
    }

    public ReturnWarwDoc findReturnWarwDocById(Long id){
        return returnWarwDocRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("ReturnWarwDoc not found"));
    }

    public StoreProduct findStoreProductById(Long id){
        return storeProductRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("StoreProduct not found"));
    }


}
