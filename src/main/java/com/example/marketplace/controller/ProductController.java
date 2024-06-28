package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.ProductReqDTO;
import com.example.marketplace.dto.responseDTO.CategoryResDTO;
import com.example.marketplace.dto.responseDTO.ProductResDTO;
import com.example.marketplace.service.CategoryService;
import com.example.marketplace.service.MeasurementService;
import com.example.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final MeasurementService measurementService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("product");
        mv.addObject("productList",productService.getALLProduct());
        mv.addObject("categoryList",categoryService.getALLCategory());
        mv.addObject("measurementList",measurementService.getALLMeasurement());
        return mv;
    }
    
    @GetMapping("/{id}")
    ProductResDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PostMapping()
    ModelAndView createProduct(@RequestParam("name") String name,@RequestParam("unitTypeId") Long unitTypeId,@RequestParam("categoryId") Long categoryId,@RequestParam("amount") Integer amount){
        productService.createProduct(new ProductReqDTO(name,categoryId,unitTypeId,amount));
        return new ModelAndView("redirect:/market/product");
    }

    @PostMapping("/{id}")
    ModelAndView updateProduct(@PathVariable Long id,@RequestParam("name") String name,@RequestParam("unitTypeId") Long unitTypeId,@RequestParam("categoryId") Long categoryId,@RequestParam("amount") Integer amount){
        productService.updateProduct(id,new ProductReqDTO(name,categoryId,unitTypeId,amount));
        return new ModelAndView("redirect:/market/product");
    }

    @GetMapping("delete/{id}")
    ModelAndView deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ModelAndView("redirect:/market/product");
    }

}

