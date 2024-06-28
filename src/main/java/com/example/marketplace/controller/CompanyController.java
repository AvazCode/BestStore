package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.CompanyReqDTO;
import com.example.marketplace.dto.responseDTO.CompanyResDTO;
import com.example.marketplace.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/market/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("company");
        return mv.addObject("companies",companyService.getALLCompany());
    }
    @GetMapping("/{id}")
    CompanyResDTO getCompanyById(@PathVariable Long id){

        return companyService.getCompanyById(id);
    }
    @PostMapping()
    ModelAndView createCompany(@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("phoneNumber") String phoneNumber,@RequestParam("description") String  description){
        companyService.createCompany(new CompanyReqDTO(name,address,phoneNumber,description));
        return new ModelAndView("redirect:/market/company");
    }
    @PostMapping("/{id}")
    ModelAndView updateCompany(@PathVariable Long id,@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("phoneNumber") String phoneNumber,@RequestParam("description") String  description){
        companyService.updateCompany(id,new CompanyReqDTO(name,address,phoneNumber,description));
        return new ModelAndView("redirect:/market/company");
    }
    @GetMapping("delete/{id}")
    ModelAndView deleteCompany(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return new ModelAndView("redirect:/market/company");
    }

}

