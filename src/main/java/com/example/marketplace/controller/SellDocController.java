package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.SellDocReqDTO;
import com.example.marketplace.dto.requestDTO.SellDocReqDTO;
import com.example.marketplace.dto.responseDTO.SellDocResDTO;
import com.example.marketplace.service.SellDocService;
import com.example.marketplace.service.SellDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/market/selldoc")
@RequiredArgsConstructor
public class SellDocController {
    private final SellDocService sellDocService;
    @GetMapping
    ModelAndView getSellDocAll(){
        ModelAndView mv = new ModelAndView("selldoc");
        mv.addObject("sellDocList",sellDocService.getALLSellDoc());
        return mv;
    }
    @PostMapping
    ModelAndView createSellDoc(@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        sellDocService.createSellDoc(new SellDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/selldoc");
    }
    @PostMapping("/{id}")
    ModelAndView updateSellDoc(@PathVariable Long id,@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        sellDocService.updateSellDoc(id,new SellDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/selldoc");
    }
    @GetMapping("/delete/{id}")
    ModelAndView deleteSellDoc(@PathVariable Long id){
        sellDocService.deleteSellDocById(id);
        return new ModelAndView("redirect:/market/selldoc");
    }
}