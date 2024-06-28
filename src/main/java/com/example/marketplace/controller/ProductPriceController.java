package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.ProductPriceReqDTO;
import com.example.marketplace.dto.responseDTO.ProductPriceResDTO;
import com.example.marketplace.service.ProductPriceService;
import com.example.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/market/productprice")
@RequiredArgsConstructor
public class ProductPriceController {
    private final ProductPriceService productPriceService;
    private final ProductService productService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("productprice");
        mv.addObject("productPriceList",productPriceService.getALLProductPrice());
        mv.addObject("productList",productService.getALLProduct());
        return mv;
    }
    @GetMapping("/{id}")
    ProductPriceResDTO getProductPriceById(@PathVariable Long id){
        return productPriceService.getProductPriceById(id);
    }
    @PostMapping()
    ModelAndView createProductPrice(@RequestParam("productId") Long productId, @RequestParam("price") Double price, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime date, @RequestParam("status") Boolean status){
        productPriceService.createProductPrice(new ProductPriceReqDTO(productId,price,date,status));
        return new ModelAndView("redirect:/market/productprice");
    }

    @PostMapping ("/{id}")
    ModelAndView updateProductPrice(@PathVariable Long id,@RequestParam("productId") Long productId, @RequestParam("price") Double price, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime date, @RequestParam("status") Boolean status){
        productPriceService.updateProductPrice(id,new ProductPriceReqDTO(productId,price,date,status));
        return new ModelAndView("redirect:/market/productprice");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteProductPrice(@PathVariable Long id){

        productPriceService.deleteProductPriceById(id);
        return new ModelAndView("redirect:/market/productprice");
    }

}


