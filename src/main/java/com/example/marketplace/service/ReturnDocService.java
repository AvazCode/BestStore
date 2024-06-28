package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocResDTO;

import java.util.List;

public interface ReturnDocService {
    List<ReturnDocResDTO> getALLReturnDoc();
    ReturnDocResDTO getReturnDocById(Long id);
    ReturnDocResDTO createReturnDoc(ReturnDocReqDTO returnDocReqDTO);
    ReturnDocResDTO updateReturnDoc(Long id ,ReturnDocReqDTO returnDocReqDTO);
    void deleteReturnDocById(Long id);
}
