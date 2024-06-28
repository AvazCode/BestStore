package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.StoreProductReqDTO;
import com.example.marketplace.dto.responseDTO.StoreProductResDTO;
import com.example.marketplace.service.ProductService;
import com.example.marketplace.service.StoreProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/storeproduct")
@RequiredArgsConstructor
public class StoreProductController {
    private final StoreProductService StoreProductService;
    private final ProductService productService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("storeproduct");
        mv.addObject("storeProductList",StoreProductService.getALLStoreProduct());
        mv.addObject("productList",productService.getALLProduct());
        return mv;
    }
    @GetMapping("/{id}")
    StoreProductResDTO getStoreProductById(@PathVariable Long id){
        return StoreProductService.getStoreProductById(id);
    }
    @PostMapping()
    ModelAndView createStoreProduct(@RequestParam("productId") Long productID,@RequestParam("amount") Double amount){

        StoreProductService.createStoreProduct(new StoreProductReqDTO(productID,amount));
        return new ModelAndView("redirect:/market/storeproduct");
    }

    @PostMapping("/{id}")
    ModelAndView updateStoreProduct(@PathVariable Long id,@RequestParam("productId") Long productID,@RequestParam("amount") Double amount){
        StoreProductService.updateStoreProduct(id,new StoreProductReqDTO(productID,amount));
        return new ModelAndView("redirect:/market/storeproduct");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteStoreProduct(@PathVariable Long id){
        StoreProductService.deleteStoreProductById(id);
        return new ModelAndView("redirect:/market/storeproduct");
    }

}
