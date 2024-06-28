package com.example.marketplace.mapper;

import com.example.marketplace.dto.responseDTO.CategoryResDTO;
import com.example.marketplace.dto.responseDTO.ProductResDTO;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryResMapper implements CommonMapper<CategoryResDTO, Category> {
    @Autowired
    private  ProductResMapper productResMapper;




    @Mapping(source = "id", target = "id")
    @Mapping(target = "productResDTOList", expression = "java(findProductById(category.getProducts()))")
    public abstract CategoryResDTO toDTO(Category category);
    protected List<ProductResDTO> findProductById(List<Product> products){
        return productResMapper.toDTOs(products);


    }
}
