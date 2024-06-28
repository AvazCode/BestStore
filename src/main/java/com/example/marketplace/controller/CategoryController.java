package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.CategoryReqDTO;
import com.example.marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/market/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("category");
        mv.addObject("categoryList",categoryService.getALLCategory());
        return mv;
    }
    @GetMapping("/{id}")
    ModelAndView getCategoryById(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/market/category");
        mv.addObject( "categoryWithProducts",categoryService.getCategoryById(id));
        return mv;
    }
    @PostMapping
    ModelAndView createCategory(@RequestParam("name") String name){
        CategoryReqDTO categoryReqDTO = new CategoryReqDTO();
        categoryReqDTO.setName(name);
        categoryService.createCategory(categoryReqDTO);
        return new ModelAndView("redirect:/market/category");
    }

    @PostMapping("/{id}")
    ModelAndView updateCategory(@PathVariable Long id,@RequestParam("name") String name){
        System.out.println(name);
        CategoryReqDTO categoryReqDTO = new CategoryReqDTO();
        categoryReqDTO.setName(name);
        categoryService.updateCategory(id,categoryReqDTO);
        return new ModelAndView("redirect:/market/category");
    }

    @GetMapping("delete/{id}")
    ModelAndView deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return new ModelAndView("redirect:/market/category");
    }

}
