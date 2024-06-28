package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.SellDocItemReqDTO;
import com.example.marketplace.dto.requestDTO.SellDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.SellDocItemResDTO;
import com.example.marketplace.service.SellDocItemService;
import com.example.marketplace.service.SellDocService;
import com.example.marketplace.service.SellDocItemService;
import com.example.marketplace.service.StoreProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/selldocitem")
@RequiredArgsConstructor
public class SellDocItemController {
    private final SellDocItemService sellDocItemService;
    private final StoreProductService productService;
    private final SellDocService sellDocService;

    @GetMapping
    ModelAndView getALLSellDocItem(){
        ModelAndView mv = new ModelAndView("selldocitem");
        mv.addObject("sellDocItemList",sellDocItemService.getALLSellDocItem());
        mv.addObject("productList",productService.getALLStoreProduct());
        mv.addObject("sellDocList",sellDocService.getALLSellDoc());
        return mv;
    }

    @PostMapping
    ModelAndView createSellDocItem(@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("count") Long count,@RequestParam("price") Long price){
        sellDocItemService.createSellDocItem(new SellDocItemReqDTO(documentId,productId,count,price));
        return new ModelAndView("redirect:/market/selldocitem");
    }
    @PostMapping("/{id}")
    ModelAndView updateSellDocItem(@PathVariable Long id,@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("count") Long count,@RequestParam("price") Long price){
        sellDocItemService.updateSellDocItem(id, new SellDocItemReqDTO(documentId,productId,count,price));
        return new ModelAndView("redirect:/market/selldocitem");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteById(@PathVariable Long id){
        sellDocItemService.deleteSellDocItemById(id);
        return new ModelAndView("redirect:/market/selldocitem");
    }
}
