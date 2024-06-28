package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.CategoryReqDTO;
import com.example.marketplace.dto.responseDTO.CategoryResDTO;
import com.example.marketplace.dto.responseDTO.CategoryWithProductsResDTO;
import com.example.marketplace.dto.responseDTO.ProductResDTO;
import com.example.marketplace.entity.Category;
import com.example.marketplace.mapper.*;
import com.example.marketplace.repostory.CategoryRepostory;
import com.example.marketplace.repostory.ProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepostory categoryRepostory;
    private final CategoryReqMapper categoryReqMapper;
    private final CategoryResMapper categoryResMapper;
    private final ProductResMapper productResMapper;
    private final CategoryWithProductsMapper categoryWithProductsMapper;
    private final ProductRepostory productRepostory;

    @Override
    public List<CategoryResDTO> getALLCategory() {
        List<Category> categories = categoryRepostory.findAll();
        for (Category category : categories) {
            category.setProducts(productRepostory.findByCategoryId(category.getId()));
        }
        return categoryResMapper.toDTOs(categories);
    }

    @Override
    public CategoryWithProductsResDTO getCategoryById(Long id) {
        Category category = new Category();
        System.out.println(productRepostory.findByCategoryId(id).stream());
        category.setProducts(productRepostory.findByCategoryId(id));
        return categoryWithProductsMapper.toDTO(category);
    }

    @Override
    public CategoryResDTO createCategory(CategoryReqDTO categoryReqDTO) {

        return categoryResMapper.toDTO(categoryRepostory.save(categoryReqMapper.toENTITY(categoryReqDTO)));
    }

    @Override
    public CategoryResDTO updateCategory(Long id, CategoryReqDTO categoryReqDTO) {
        Category category = categoryRepostory.getReferenceById(id);
        category.setName(categoryReqDTO.getName());
        return categoryResMapper.toDTO(categoryRepostory.save(category));
    }

    @Override
    public void deleteCategoryById(Long id) {
       categoryRepostory.deleteById(id);
    }
}
