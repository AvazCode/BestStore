package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.CategoryReqDTO;
import com.example.marketplace.dto.responseDTO.CategoryResDTO;
import com.example.marketplace.dto.responseDTO.CategoryWithProductsResDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<CategoryResDTO> getALLCategory();
    CategoryWithProductsResDTO getCategoryById(Long id);
    CategoryResDTO createCategory(CategoryReqDTO categoryReqDTO);
    CategoryResDTO updateCategory(Long id ,CategoryReqDTO categoryReqDTO);
    void deleteCategoryById(Long id);
}
