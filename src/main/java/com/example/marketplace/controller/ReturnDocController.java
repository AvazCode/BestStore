package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.ReturnDocReqDTO;
import com.example.marketplace.dto.requestDTO.ReturnDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocResDTO;
import com.example.marketplace.service.ReturnDocService;
import com.example.marketplace.service.ReturnDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/market/returndoc")
@RequiredArgsConstructor
public class ReturnDocController {
    private final ReturnDocService returnDocService;
    @GetMapping
    ModelAndView getReturnDocAll(){
        ModelAndView mv = new ModelAndView("returndoc");
        mv.addObject("returnDocList",returnDocService.getALLReturnDoc());
        return mv;
    }
    @PostMapping
    ModelAndView createReturnDoc(@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        returnDocService.createReturnDoc(new ReturnDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/returndoc");
    }
    @PostMapping("/{id}")
    ModelAndView updateReturnDoc(@PathVariable Long id,@RequestParam("number") String  number,@RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        returnDocService.updateReturnDoc(id,new ReturnDocReqDTO(number,date));
        return new ModelAndView("redirect:/market/returndoc");
    }
    @GetMapping("/delete/{id}")
    ModelAndView deleteReturnDoc(@PathVariable Long id){
        returnDocService.deleteReturnDocById(id);
        return new ModelAndView("redirect:/market/returndoc");
    }
}
