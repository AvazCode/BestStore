package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.MeasurementReqDTO;
import com.example.marketplace.dto.responseDTO.MeasurementResDTO;
import com.example.marketplace.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market/measurement")
@RequiredArgsConstructor
public class MeasurementController {
    private final MeasurementService measurementService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("measurement");
        mv.addObject("measureList",measurementService.getALLMeasurement());
        return mv;
    }
    @GetMapping("/{id}")
    MeasurementResDTO getMeasurementById(@PathVariable Long id){
        return measurementService.getMeasurementById(id);
    }
    @PostMapping()
    ModelAndView createMeasurement(@RequestParam("name") String name){
        measurementService.createMeasurement(new MeasurementReqDTO(name));
        return new ModelAndView("redirect:/market/measurement");
    }

    @PostMapping("/{id}")
    ModelAndView updateMeasurement(@PathVariable Long id,@RequestParam("name") String name){
         measurementService.updateMeasurement(id,new MeasurementReqDTO(name));
        return new ModelAndView("redirect:/market/measurement");
    }

    @GetMapping("delete/{id}")
    ModelAndView deleteMeasurement(@PathVariable Long id){
        measurementService.deleteMeasurementById(id);
        return new ModelAndView("redirect:/market/measurement");
    }

}

