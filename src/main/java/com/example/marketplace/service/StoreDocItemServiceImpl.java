package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.StoreDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.StoreDocItemResDTO;
import com.example.marketplace.entity.StoreDocItem;
import com.example.marketplace.mapper.StoreDocItemReqMapper;
import com.example.marketplace.mapper.StoreDocItemResMapper;
import com.example.marketplace.repostory.ProductRepostory;
import com.example.marketplace.repostory.StoreDocItemRepostory;
import com.example.marketplace.repostory.StoreDocRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreDocItemServiceImpl implements StoreDocItemService{
    private final StoreDocItemResMapper storeDocItemResMapper;
    private final StoreDocItemRepostory storeDocItemRepostory;
    private final StoreDocItemReqMapper storeDocItemReqMapper;
    private final ProductRepostory productRepostory;
    private final StoreDocRepostory storeDocRepostory;
    @Override
    public List<StoreDocItemResDTO> getALLStoreDocItem() {
        return storeDocItemResMapper.toDTOs(storeDocItemRepostory.findAll());
    }

    @Override
    public StoreDocItemResDTO getStoreDocItemById(Long id) {
        return storeDocItemResMapper.toDTO(storeDocItemRepostory.getReferenceById(id));
    }

    @Override
    public StoreDocItemResDTO createStoreDocItem(StoreDocItemReqDTO storeDocItemReqDTO) {
        return storeDocItemResMapper.toDTO(storeDocItemRepostory.save(storeDocItemReqMapper.toENTITY(storeDocItemReqDTO)));
    }

    @Override
    public StoreDocItemResDTO updateStoreDocItem(Long id, StoreDocItemReqDTO storeDocItemReqDTO) {
        StoreDocItem storeDocItem = storeDocItemRepostory.getReferenceById(id);
        storeDocItem.setProduct(productRepostory.getReferenceById(storeDocItemReqDTO.getProduct_id()));
        storeDocItem.setStoreDoc(storeDocRepostory.getReferenceById(storeDocItemReqDTO.getStoreDoc_id()));
        storeDocItem.setCount(storeDocItemReqDTO.getCount());
        return storeDocItemResMapper.toDTO(storeDocItemRepostory.save(storeDocItem));
    }

    @Override
    public void deleteStoreDocItemById(Long id) {
        storeDocItemRepostory.deleteById(id);
    }
}
