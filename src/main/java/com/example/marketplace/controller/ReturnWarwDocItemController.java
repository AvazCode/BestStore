package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocItemReqDTO;
import com.example.marketplace.dto.requestDTO.ReturnWarwDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnWarwDocItemResDTO;
import com.example.marketplace.service.*;
import com.example.marketplace.service.ReturnWarwDocItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/warehousedocitem")
@RequiredArgsConstructor
public class ReturnWarwDocItemController {
    private final ReturnWarwDocItemService storeDocItemService;
    private final StoreProductService storeProductService;
    private final ReturnWarwDocService storeDocService;
    private final ProductService productService;

    @GetMapping
    ModelAndView getALLReturnWarwDocItem(){
        ModelAndView mv = new ModelAndView("warehousedocitem");
        mv.addObject("returnWareDocItemList",storeDocItemService.getALLReturnWarwDocItem());
        mv.addObject("productList",productService.getALLProduct());
        mv.addObject("storeProductList",storeProductService.getALLStoreProduct());
        mv.addObject("returnWareDocList",storeDocService.getALLReturnWarwDoc());
        return mv;
    }

    @PostMapping
    ModelAndView createReturnWarwDocItem(@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("storeProductId") Long storeProductId,@RequestParam("count") Long count){
        storeDocItemService.createReturnWarwDocItem(new ReturnWarwDocItemReqDTO(documentId,storeProductId,productId,count));
        return new ModelAndView("redirect:/market/warehousedocitem");
    }
    @PostMapping("/{id}")
    ModelAndView updateReturnWarwDocItem(@PathVariable Long id,@RequestParam("documentId") Long documentId,@RequestParam("storeProductId") Long storeProductId,@RequestParam("productId") Long productId,@RequestParam("count") Long count){
        storeDocItemService.updateReturnWarwDocItem(id, new ReturnWarwDocItemReqDTO(documentId,storeProductId,productId,count));
        return new ModelAndView("redirect:/market/warehousedocitem");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteById(@PathVariable Long id){
        storeDocItemService.deleteReturnWarwDocItemById(id);
        return new ModelAndView("redirect:/market/warehousedocitem");
    }
}
