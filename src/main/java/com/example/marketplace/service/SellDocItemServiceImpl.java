package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.SellDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.SellDocItemResDTO;
import com.example.marketplace.entity.SellDocItem;
import com.example.marketplace.mapper.SellDocItemReqMapper;
import com.example.marketplace.mapper.SellDocItemResMapper;
import com.example.marketplace.repostory.SellDocItemRepostory;
import com.example.marketplace.repostory.SellDocRepostory;
import com.example.marketplace.repostory.StoreProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellDocItemServiceImpl implements SellDocItemService{
    private final SellDocItemReqMapper sellDocItemReqMapper;
    private final SellDocItemResMapper sellDocItemResMapper;
    private final SellDocItemRepostory sellDocItemRepostory;
    private final StoreProductRepostory storeProductRepostory;
    private final SellDocRepostory sellDocRepostory;
    @Override
    public List<SellDocItemResDTO> getALLSellDocItem() {
        return sellDocItemResMapper.toDTOs(sellDocItemRepostory.findAll());
    }

    @Override
    public SellDocItemResDTO getSellDocItemById(Long id) {
        return sellDocItemResMapper.toDTO(sellDocItemRepostory.getReferenceById(id));
    }

    @Override
    public SellDocItemResDTO createSellDocItem(SellDocItemReqDTO sellDocItemReqDTO) {

        return sellDocItemResMapper.toDTO(sellDocItemRepostory.save(sellDocItemReqMapper.toENTITY(sellDocItemReqDTO)));
    }

    @Override
    public SellDocItemResDTO updateSellDocItem(Long id, SellDocItemReqDTO sellDocItemReqDTO) {
        SellDocItem sellDocItem = sellDocItemRepostory.getReferenceById(id);
        sellDocItem.setCount(sellDocItemReqDTO.getCount());
        sellDocItem.setPrice(sellDocItemReqDTO.getPrice());
        sellDocItem.setStoreProduct(storeProductRepostory.getReferenceById(sellDocItemReqDTO.getStoreProduct_id()));
        sellDocItem.setSellDoc(sellDocRepostory.getReferenceById(sellDocItemReqDTO.getSellDoc_id()));
        return sellDocItemResMapper.toDTO(sellDocItemRepostory.save(sellDocItem));
    }

    @Override
    public void deleteSellDocItemById(Long id) {
        sellDocItemRepostory.deleteById(id);
    }
}
