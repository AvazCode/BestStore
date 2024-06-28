package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocReqDTO;
import com.example.marketplace.dto.requestDTO.ReturnWarwDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnWarwDocResDTO;
import com.example.marketplace.service.ReturnWarwDocService;
import com.example.marketplace.service.ReturnWarwDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/market/warehousedoc")
@RequiredArgsConstructor
public class ReturnWarwDocController {
    private final ReturnWarwDocService returnWarwDocService;
    @GetMapping
    ModelAndView getReturnWarwDocAll(){
        ModelAndView mv = new ModelAndView("warehousedoc");
        mv.addObject("returnWarwDocList",returnWarwDocService.getALLReturnWarwDoc());
        return mv;
    }
    @PostMapping
    ModelAndView createReturnWarwDoc(@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        returnWarwDocService.createReturnWarwDoc(new ReturnWarwDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/warehousedoc");
    }
    @PostMapping("/{id}")
    ModelAndView updateReturnWarwDoc(@PathVariable Long id,@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        returnWarwDocService.updateReturnWarwDoc(id,new ReturnWarwDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/warehousedoc");
    }
    @GetMapping("/delete/{id}")
    ModelAndView deleteReturnWarwDoc(@PathVariable Long id){
        returnWarwDocService.deleteReturnWarwDocById(id);
        return new ModelAndView("redirect:/market/warehousedoc");
    }
}