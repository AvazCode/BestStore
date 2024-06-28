package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.SellDocReqDTO;
import com.example.marketplace.dto.responseDTO.SellDocResDTO;
import com.example.marketplace.entity.SellDoc;
import com.example.marketplace.mapper.SellDocReqMapper;
import com.example.marketplace.mapper.SellDocResMapper;
import com.example.marketplace.repostory.SellDocRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellDocServiceImpl implements SellDocService {
    private final SellDocReqMapper sellDocReqMapper;
    private final SellDocResMapper sellDocResMapper;
    private final SellDocRepostory sellDocRepostory;
    @Override
    public List<SellDocResDTO> getALLSellDoc() {
        return sellDocResMapper.toDTOs(sellDocRepostory.findAll());
    }

    @Override
    public SellDocResDTO getSellDocById(Long id) {
        return sellDocResMapper.toDTO(sellDocRepostory.getReferenceById(id));
    }

    @Override
    public SellDocResDTO createSellDoc(SellDocReqDTO sellDocReqDTO) {

        return sellDocResMapper.toDTO(sellDocRepostory.save(sellDocReqMapper.toENTITY(sellDocReqDTO)));
    }

    @Override
    public SellDocResDTO updateSellDoc(Long id, SellDocReqDTO sellDocReqDTO) {
        SellDoc sellDoc = sellDocRepostory.getReferenceById(id);
        sellDoc.setDocNumber(sellDocReqDTO.getDocNumber());
        sellDoc.setDate(sellDocReqDTO.getDate());
        return sellDocResMapper.toDTO(sellDocRepostory.save(sellDoc));
    }

    @Override
    public void deleteSellDocById(Long id) {
        sellDocRepostory.deleteById(id);
    }
}
