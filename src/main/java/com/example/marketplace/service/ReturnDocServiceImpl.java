package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocResDTO;
import com.example.marketplace.entity.ReturnDoc;
import com.example.marketplace.mapper.ReturnDocReqMapper;
import com.example.marketplace.mapper.ReturnDocResMapper;
import com.example.marketplace.repostory.ProductRepostory;
import com.example.marketplace.repostory.ReturnDocRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnDocServiceImpl implements ReturnDocService {
    private final ReturnDocReqMapper returnDocReqMapper;
    private final ReturnDocResMapper returnDocResMapper;
    private final ReturnDocRepostory returnDocRepostory;

    @Override
    public List<ReturnDocResDTO> getALLReturnDoc() {
        return returnDocResMapper.toDTOs(returnDocRepostory.findAll());
    }

    @Override
    public ReturnDocResDTO getReturnDocById(Long id) {
        return returnDocResMapper.toDTO(returnDocRepostory.getReferenceById(id));
    }

    @Override
    public ReturnDocResDTO createReturnDoc(ReturnDocReqDTO returnDocReqDTO) {

        return returnDocResMapper.toDTO(returnDocRepostory.save(returnDocReqMapper.toENTITY(returnDocReqDTO)));
    }

    @Override
    public ReturnDocResDTO updateReturnDoc(Long id, ReturnDocReqDTO returnDocReqDTO) {
        ReturnDoc returnDoc = returnDocRepostory.getReferenceById(id);
        returnDoc.setDocNumber(returnDocReqDTO.getDocNumber());
        returnDoc.setData(returnDocReqDTO.getData());
        return returnDocResMapper.toDTO(returnDocRepostory.save(returnDoc));
    }

    @Override
    public void deleteReturnDocById(Long id) {
        returnDocRepostory.deleteById(id);
    }
}