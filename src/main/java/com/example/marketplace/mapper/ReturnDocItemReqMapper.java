package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.ReturnDocItemReqDTO;
import com.example.marketplace.dto.requestDTO.ReturnDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocItemResDTO;
import com.example.marketplace.entity.ReturnDoc;
import com.example.marketplace.entity.ReturnDocItem;
import com.example.marketplace.entity.StoreProduct;
import com.example.marketplace.repostory.ReturnDocItemRepostory;
import com.example.marketplace.repostory.ReturnDocRepostory;
import com.example.marketplace.repostory.StoreProductRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReturnDocItemReqMapper implements CommonMapper<ReturnDocItemReqDTO, ReturnDocItem>{
    @Autowired
    private StoreProductRepostory storeProductRepostory;
    @Autowired
    private ReturnDocRepostory returnDocRepostory;




    @Mapping(target = "storeProduct", expression = "java(findStoreProductById(returnDocItemReqDTO.getStoreProduct_id()))")
    @Mapping(target = "returnDoc",expression = "java(findReturnDocById(returnDocItemReqDTO.getReturnDoc_id()))")
    public abstract ReturnDocItem toENTITY(ReturnDocItemReqDTO returnDocItemReqDTO);

    protected StoreProduct findStoreProductById(Long id){
        return storeProductRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("StoreProduct is not found"));
    }

    protected ReturnDoc findReturnDocById(Long id){
        return returnDocRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("ReturnDoc is not found"));
    }
}
