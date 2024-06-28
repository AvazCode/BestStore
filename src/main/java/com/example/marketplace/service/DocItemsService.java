package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.DocItemsReqDTO;
import com.example.marketplace.dto.responseDTO.DocItemsResDTO;

import java.util.List;

public interface DocItemsService {
    List<DocItemsResDTO> getALLDocItems();
    DocItemsResDTO getDocItemsById(Long id);
    DocItemsResDTO createDocItems(DocItemsReqDTO docItemsReqDTO);
    DocItemsResDTO updateDocItems(Long id ,DocItemsReqDTO docItemsReqDTO);
    void deleteDocItemsById(Long id);
}
