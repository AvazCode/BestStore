package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocItemResDTO;

import java.util.List;

public interface ReturnDocItemService {
    List<ReturnDocItemResDTO> getALLReturnDocItem();
    ReturnDocItemResDTO getReturnDocItemById(Long id);
    ReturnDocItemResDTO createReturnDocItem(ReturnDocItemReqDTO returnDocItemReqDTO);
    ReturnDocItemResDTO updateReturnDocItem(Long id ,ReturnDocItemReqDTO returnDocItemReqDTO);
    void deleteReturnDocItemById(Long id);
}
