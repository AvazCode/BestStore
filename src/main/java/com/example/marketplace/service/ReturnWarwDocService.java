package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnWarwDocResDTO;

import java.util.List;

public interface ReturnWarwDocService {
    List<ReturnWarwDocResDTO> getALLReturnWarwDoc();
    ReturnWarwDocResDTO getReturnWarwDocById(Long id);
    ReturnWarwDocResDTO createReturnWarwDoc(ReturnWarwDocReqDTO returnWarwDocReqDTO);
    ReturnWarwDocResDTO updateReturnWarwDoc(Long id ,ReturnWarwDocReqDTO returnWarwDocReqDTO);
    void deleteReturnWarwDocById(Long id);
}
