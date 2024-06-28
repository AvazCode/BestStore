package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.StoreDocReqDTO;
import com.example.marketplace.dto.requestDTO.StoreDocReqDTO;
import com.example.marketplace.dto.responseDTO.StoreDocResDTO;
import com.example.marketplace.dto.responseDTO.StoreDocResDTO;
import com.example.marketplace.entity.StoreDoc;
import com.example.marketplace.mapper.StoreDocReqMapper;
import com.example.marketplace.mapper.StoreDocResMapper;
import com.example.marketplace.repostory.StoreDocRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StoreDocServiceImpl implements StoreDocService{
    private final StoreDocRepostory storeDocRepostory;
    private final StoreDocResMapper storeDocResMapper;
    private final StoreDocReqMapper storeDocReqMapper;

    @Override
    public List<StoreDocResDTO> getALLStoreDoc() {
        return storeDocResMapper.toDTOs(storeDocRepostory.findAll());
    }

    @Override
    public StoreDocResDTO getStoreDocById(Long id) {
        return storeDocResMapper.toDTO(storeDocRepostory.getReferenceById(id));
    }

    @Override
    public StoreDocResDTO createStoreDoc(StoreDocReqDTO storeDocReqDTO) {
        return storeDocResMapper.toDTO(storeDocRepostory.save(storeDocReqMapper.toENTITY(storeDocReqDTO)));
    }

    @Override
    public StoreDocResDTO updateStoreDoc(Long id, StoreDocReqDTO storeDocReqDTO) {
        StoreDoc storeDoc = storeDocRepostory.getReferenceById(id);
        storeDoc.setDocNumber(storeDocReqDTO.getDocNumber());
        storeDoc.setData(storeDocReqDTO.getData());
        return storeDocResMapper.toDTO(storeDocRepostory.save(storeDoc));
    }

    @Override
    public void deleteStoreDocById(Long id) {
         storeDocRepostory.deleteById(id);
    }
}
