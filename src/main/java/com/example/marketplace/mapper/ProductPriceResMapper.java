package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.ProductPriceReqDTO;
import com.example.marketplace.dto.responseDTO.ProductPriceResDTO;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductPriceResMapper extends CommonMapper<ProductPriceResDTO, ProductPrice>{
    @Mapping(source = "product",target = "productResDTO")
    ProductPriceResDTO toDTO(ProductPrice productPrice);

    @Mapping(source = "productResDTO",target = "product")
    ProductPrice toENTITY(ProductPriceResDTO productPriceResDTO);
}
