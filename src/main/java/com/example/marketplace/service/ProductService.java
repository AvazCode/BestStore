package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ProductReqDTO;
import com.example.marketplace.dto.responseDTO.ProductResDTO;

import java.util.List;

public interface ProductService {
    List<ProductResDTO> getALLProduct();
    ProductResDTO getProductById(Long id);
    ProductResDTO createProduct(ProductReqDTO productReqDTO);
    ProductResDTO updateProduct(Long id ,ProductReqDTO productReqDTO);
    void deleteProductById(Long id);
}
