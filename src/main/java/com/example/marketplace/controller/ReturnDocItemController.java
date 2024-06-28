package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.ReturnDocItemReqDTO;
import com.example.marketplace.dto.requestDTO.ReturnDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocItemResDTO;
import com.example.marketplace.service.*;
import com.example.marketplace.service.ReturnDocItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/returndocitem")
@RequiredArgsConstructor
public class ReturnDocItemController {
    private final ReturnDocItemService returnDocItemService;
    private final StoreProductService productService;
    private final ReturnDocService returnDocService;

    @GetMapping
    ModelAndView getALLReturnDocItem(){
        ModelAndView mv = new ModelAndView("returndocitem");
        mv.addObject("returnDocItemList",returnDocItemService.getALLReturnDocItem());
        mv.addObject("productList",productService.getALLStoreProduct());
        mv.addObject("returnDocList",returnDocService.getALLReturnDoc());
        return mv;
    }

    @PostMapping
    ModelAndView createReturnDocItem(@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("count") Long count){
        returnDocItemService.createReturnDocItem(new ReturnDocItemReqDTO(documentId,productId,count));
        return new ModelAndView("redirect:/market/returndocitem");
    }
    @PostMapping("/{id}")
    ModelAndView updateReturnDocItem(@PathVariable Long id,@RequestParam("documentId") Long documentId,@RequestParam("productId") Long productId,@RequestParam("count") Long count){
        returnDocItemService.updateReturnDocItem(id, new ReturnDocItemReqDTO(documentId,productId,count));
        return new ModelAndView("redirect:/market/returndocitem");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteById(@PathVariable Long id){
        returnDocItemService.deleteReturnDocItemById(id);
        return new ModelAndView("redirect:/market/returndocitem");
    }
}
