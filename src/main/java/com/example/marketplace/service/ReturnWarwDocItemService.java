package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnWarwDocItemResDTO;

import java.util.List;

public interface ReturnWarwDocItemService {
    List<ReturnWarwDocItemResDTO> getALLReturnWarwDocItem();
    ReturnWarwDocItemResDTO getReturnWarwDocItemById(Long id);
    ReturnWarwDocItemResDTO createReturnWarwDocItem(ReturnWarwDocItemReqDTO returnWarwDocItemReqDTO);
    ReturnWarwDocItemResDTO updateReturnWarwDocItem(Long id ,ReturnWarwDocItemReqDTO returnWarwDocItemReqDTO);
    void deleteReturnWarwDocItemById(Long id);
}
