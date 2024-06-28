package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnWarwDocResDTO;
import com.example.marketplace.entity.ReturnWarwDoc;
import com.example.marketplace.mapper.ReturnWarwDocReqMapper;
import com.example.marketplace.mapper.ReturnWarwDocResMapper;
import com.example.marketplace.repostory.ReturnWarwDocRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReturnWarwDocServiceImpl implements ReturnWarwDocService {
    private final ReturnWarwDocReqMapper returnWarwDocReqMapper;
    private final ReturnWarwDocResMapper returnWarwDocResMapper;
    private final ReturnWarwDocRepostory returnWarwDocRepostory;

    @Override
    public List<ReturnWarwDocResDTO> getALLReturnWarwDoc() {
        return returnWarwDocResMapper.toDTOs(returnWarwDocRepostory.findAll());
    }

    @Override
    public ReturnWarwDocResDTO getReturnWarwDocById(Long id) {
        return returnWarwDocResMapper.toDTO(returnWarwDocRepostory.getReferenceById(id));
    }

    @Override
    public ReturnWarwDocResDTO createReturnWarwDoc(ReturnWarwDocReqDTO returnWarwDocReqDTO) {

        return returnWarwDocResMapper.toDTO(returnWarwDocRepostory.save(returnWarwDocReqMapper.toENTITY(returnWarwDocReqDTO)));
    }

    @Override
    public ReturnWarwDocResDTO updateReturnWarwDoc(Long id, ReturnWarwDocReqDTO returnWarwDocReqDTO) {
        ReturnWarwDoc returnWarwDoc = returnWarwDocRepostory.getReferenceById(id);
        returnWarwDoc.setDocNumber(returnWarwDocReqDTO.getDocNumber());
        returnWarwDoc.setDate(returnWarwDocReqDTO.getDate());
        return returnWarwDocResMapper.toDTO(returnWarwDocRepostory.save(returnWarwDoc));
    }

    @Override
    public void deleteReturnWarwDocById(Long id) {
        returnWarwDocRepostory.deleteById(id);
    }
}
