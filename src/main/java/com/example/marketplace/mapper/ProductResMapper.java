package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.ProductResDTO;
import com.example.marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProductResMapper extends CommonMapper<ProductResDTO, Product> {
    @Mapping(source = "categoryResDTO",target = "category")
    @Mapping(source = "measurementResDTO",target = "measurement")
    Product toENTITY(ProductResDTO productResDTO);

    @Mapping(source = "category",target = "categoryResDTO")
    @Mapping(source = "measurement",target = "measurementResDTO")
    @Mapping(source = "id",target = "id")
    ProductResDTO toDTO(Product product);
}
