package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.CategoryReqDTO;
import com.example.marketplace.dto.responseDTO.CategoryWithProductsResDTO;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Product;
import com.example.marketplace.repostory.CategoryRepostory;
import com.example.marketplace.repostory.ProductRepostory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper(componentModel = "spring")

public interface CategoryWithProductsMapper extends CommonMapper<CategoryWithProductsResDTO,Category>{

    @Mapping(target = "productResDTOList", source = "products")
    CategoryWithProductsResDTO toDTO(Category category);
}
