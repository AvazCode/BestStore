package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.DocItemsReqDTO;
import com.example.marketplace.entity.DocItems;
import com.example.marketplace.entity.Document;
import com.example.marketplace.entity.Product;
import com.example.marketplace.repostory.DocumentRepostory;
import com.example.marketplace.repostory.ProductRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class DocItemsReqMapper implements CommonMapper<DocItemsReqDTO, DocItems>{
    @Autowired
    private  DocumentRepostory documentRepostory;
    @Autowired
    private  ProductRepostory productRepostory;

    @Mapping(target = "document",expression = "java(findDocumentById(docItemsReqDTO.getDocument_id()))")
    @Mapping(target = "product",expression = "java(findProductById(docItemsReqDTO.getProduct_id()))")
    public abstract DocItems toENTITY(DocItemsReqDTO docItemsReqDTO);

    protected Document findDocumentById(Long id){
        System.out.println(id);
        System.out.println(documentRepostory.findById(id));
        return documentRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("Not found document"));
    }

    protected Product findProductById(Long id){
        System.out.println(id);
        System.out.println(productRepostory.findById(id));
        return productRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("Not found product"));
    }



}
