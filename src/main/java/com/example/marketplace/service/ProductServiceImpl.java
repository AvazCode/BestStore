package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ProductReqDTO;
import com.example.marketplace.dto.responseDTO.ProductResDTO;
import com.example.marketplace.entity.Product;
import com.example.marketplace.mapper.ProductReqMapper;
import com.example.marketplace.mapper.ProductResMapper;
import com.example.marketplace.repostory.CategoryRepostory;
import com.example.marketplace.repostory.MeasurementRepostory;
import com.example.marketplace.repostory.ProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepostory productRepostory;
    private final ProductReqMapper productReqMapper;
    private final ProductResMapper productResMapper;
    private final CategoryRepostory categoryRepostory;
    private final MeasurementRepostory measurementRepostory;
    @Override
    public List<ProductResDTO> getALLProduct() {
        return productResMapper.toDTOs(productRepostory.findAll());
    }

    @Override
    public ProductResDTO getProductById(Long id) {
        return productResMapper.toDTO(productRepostory.getReferenceById(id));
    }

    @Override
    public ProductResDTO createProduct(ProductReqDTO productReqDTO) {
        System.out.println(productReqDTO.getCategory_id());

        return productResMapper.toDTO(productRepostory.save(productReqMapper.toENTITY(productReqDTO)));
    }

    @Override
    public ProductResDTO updateProduct(Long id, ProductReqDTO productReqDTO) {
        Product product = productRepostory.getReferenceById(id);
        product.setName(productReqDTO.getName());
        product.setMeasurement(measurementRepostory.getReferenceById(productReqDTO.getMeasurement_id()));
        product.setAmount(productReqDTO.getAmount());
        product.setCategory(categoryRepostory.getReferenceById(productReqDTO.getCategory_id()));
        return productResMapper.toDTO(productRepostory.save(product));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepostory.deleteById(id);
    }
}
