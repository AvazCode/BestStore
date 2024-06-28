package com.example.marketplace.controller;

import com.example.marketplace.dto.requestDTO.DocumentReqDTO;
import com.example.marketplace.dto.responseDTO.DocumentResDTO;
import com.example.marketplace.service.CompanyService;
import com.example.marketplace.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/market/accept")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    private final CompanyService companyService;
    @GetMapping
    ModelAndView getAllCategories(){
        ModelAndView mv = new ModelAndView("accept");
        mv.addObject("documentList",documentService.getALLDocument());
        mv.addObject("companyList",companyService.getALLCompany());
        return mv;
    }
    @GetMapping("/{id}")
    DocumentResDTO getDocumentById(@PathVariable Long id){

        return documentService.getDocumentById(id);
    }
    @PostMapping()
    ModelAndView createDocument(@RequestParam("number") String number, @RequestParam("companyId") Long companyId, @RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        DocumentReqDTO document = new DocumentReqDTO();
        document.setDocument_number(number);
        document.setDate(date);
        document.setCompany_id(companyId);
        documentService.createDocument(document);
        return new ModelAndView("redirect:/market/accept");
    }
    @PostMapping("/{id}")
    ModelAndView updateDocument(@PathVariable Long id,@RequestParam("number") String number,@RequestParam("companyId") Long companyId, @RequestParam("date-local") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        documentService.updateDocument(id,new DocumentReqDTO(companyId,date,number));
        return new ModelAndView("redirect:/market/accept");

    }
    @GetMapping("delete/{id}")
    ModelAndView deleteDocument(@PathVariable Long id){
        documentService.deleteDocumentById(id);
        return new ModelAndView("redirect:/market/accept");
    }

}
