package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ProductPriceReqDTO;
import com.example.marketplace.dto.responseDTO.ProductPriceResDTO;
import com.example.marketplace.entity.ProductPrice;
import com.example.marketplace.mapper.ProductPriceReqMapper;
import com.example.marketplace.mapper.ProductPriceResMapper;
import com.example.marketplace.mapper.ProductResMapper;
import com.example.marketplace.repostory.ProductPriceRepostory;
import com.example.marketplace.repostory.ProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService{
    private final ProductPriceRepostory productPriceRepostory;
    private final ProductPriceResMapper productPriceResMapper;
    private final ProductPriceReqMapper productPriceReqMapper;
    private final ProductRepostory productRepostory;
    @Override
    public List<ProductPriceResDTO> getALLProductPrice() {
        return productPriceResMapper.toDTOs(productPriceRepostory.findAll()) ;
    }

    @Override
    public ProductPriceResDTO getProductPriceById(Long id) {
        return productPriceResMapper.toDTO(productPriceRepostory.getReferenceById(id));
    }

    @Override
    public ProductPriceResDTO createProductPrice(ProductPriceReqDTO productPriceReqDTO) {
        return productPriceResMapper.toDTO(productPriceRepostory.save(productPriceReqMapper.toENTITY(productPriceReqDTO)));
    }

    @Override
    public ProductPriceResDTO updateProductPrice(Long id, ProductPriceReqDTO productPriceReqDTO) {
        ProductPrice productPrice = productPriceRepostory.getReferenceById(id);
        productPrice.setProduct(productRepostory.getReferenceById(productPriceReqDTO.getProduct_id()));
        productPrice.setPrice(productPriceReqDTO.getPrice());
        productPrice.setStatus(productPriceReqDTO.getStatus());
        productPrice.setDate(productPriceReqDTO.getDate());
        return productPriceResMapper.toDTO(productPriceRepostory.save(productPrice));
    }

    @Override
    public void deleteProductPriceById(Long id) {
       productPriceRepostory.deleteById(id);
    }
}
