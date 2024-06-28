package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.StoreDocItemReqDTO;
import com.example.marketplace.service.ProductService;
import com.example.marketplace.service.StoreDocItemService;
import com.example.marketplace.service.StoreDocService;
import com.example.marketplace.service.StoreProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/market/storedocitem")
@RequiredArgsConstructor
public class StoreDocItemController {
    private final StoreDocItemService storeDocItemService;
    private final StoreProductService productService;
    private final StoreDocService storeDocService;

    @GetMapping
    ModelAndView getALLStoreDocItem(){
        ModelAndView mv = new ModelAndView("storedocitem");
        mv.addObject("storeDocItemList",storeDocItemService.getALLStoreDocItem());
        mv.addObject("productList",productService.getALLStoreProduct());
        mv.addObject("storeDocList",storeDocService.getALLStoreDoc());
        return mv;
    }

    @PostMapping
    ModelAndView createStoreDocItem(@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("count") Long count){
        storeDocItemService.createStoreDocItem(new StoreDocItemReqDTO(documentId,productId,count));
        return new ModelAndView("redirect:/market/storedocitem");
    }
    @PostMapping("/{id}")
    ModelAndView updateStoreDocItem(@PathVariable Long id,@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("count") Long count){
        storeDocItemService.updateStoreDocItem(id, new StoreDocItemReqDTO(documentId,productId,count));
        return new ModelAndView("redirect:/market/storedocitem");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteById(@PathVariable Long id){
        storeDocItemService.deleteStoreDocItemById(id);
        return new ModelAndView("redirect:/market/storedocitem");
    }
}
