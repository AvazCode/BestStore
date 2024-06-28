package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.StoreDocReqDTO;
import com.example.marketplace.service.StoreDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/market/storedoc")
@RequiredArgsConstructor
public class StoreDocController {
    private final StoreDocService storeDocService;
    @GetMapping
    ModelAndView getStoreDocAll(){
        ModelAndView mv = new ModelAndView("storedoc");
        mv.addObject("storeDocList",storeDocService.getALLStoreDoc());
        return mv;
    }
    @PostMapping
    ModelAndView createStoreDoc(@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        storeDocService.createStoreDoc(new StoreDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/storedoc");
    }
    @PostMapping("/{id}")
    ModelAndView updateStoreDoc(@PathVariable Long id,@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        storeDocService.updateStoreDoc(id,new StoreDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/storedoc");
    }
    @GetMapping("/delete/{id}")
    ModelAndView deleteStoreDoc(@PathVariable Long id){
        storeDocService.deleteStoreDocById(id);
        return new ModelAndView("redirect:/market/storedoc");
    }
}
