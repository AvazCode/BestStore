package com.example.marketplace.controller;


import com.example.marketplace.dto.requestDTO.DocItemsReqDTO;
import com.example.marketplace.dto.responseDTO.DocItemsResDTO;
import com.example.marketplace.service.DocItemsService;
import com.example.marketplace.service.DocumentService;
import com.example.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/acceptitem")
@RequiredArgsConstructor
public class DocItemsController {
    private final DocItemsService docItemsService;
    private final ProductService productService;
    private final DocumentService documentService;
    private final
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("acceptitem");
        mv.addObject("docItems",docItemsService.getALLDocItems());
        mv.addObject("products",productService.getALLProduct());
        mv.addObject("documents",documentService.getALLDocument());
        return mv;
    }
    @GetMapping("/{id}")
    DocItemsResDTO getDocItemsById(@PathVariable Long id){

        return docItemsService.getDocItemsById(id);
    }
    @PostMapping()
    ModelAndView createDocItems(@RequestParam("documentId") Long docId,@RequestParam("productId") Long productId,@RequestParam("comePrice") Integer comePrice,@RequestParam("count") Integer count){
        docItemsService.createDocItems(new DocItemsReqDTO(docId,productId,comePrice,count));
        return new ModelAndView("redirect:/market/acceptitem");
    }

    @PostMapping("/{id}")
    ModelAndView updateDocItems(@PathVariable Long id,@RequestParam("documentId") Long docId,@RequestParam("productId") Long productId,@RequestParam("comePrice") Integer comePrice,@RequestParam("count") Integer count){
        docItemsService.updateDocItems(id,new DocItemsReqDTO(docId,productId,comePrice,count));
        return new ModelAndView("redirect:/market/acceptitem");
    }
    @GetMapping("delete/{id}")
    ModelAndView deleteDocItems(@PathVariable Long id){
        docItemsService.deleteDocItemsById(id);
        return new ModelAndView("redirect:/market/acceptitem");
    }

}
