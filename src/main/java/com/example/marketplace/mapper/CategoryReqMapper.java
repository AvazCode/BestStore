package com.example.marketplace.mapper;

import com.example.marketplace.dto.requestDTO.CategoryReqDTO;
import com.example.marketplace.dto.responseDTO.CategoryResDTO;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Product;
import com.example.marketplace.mapper.CommonMapper;
import com.example.marketplace.repostory.CategoryRepostory;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class CategoryReqMapper implements CommonMapper<CategoryReqDTO, Category> {

}
