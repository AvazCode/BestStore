package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnWarwDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnWarwDocItemResDTO;
import com.example.marketplace.entity.ReturnWarwDocItem;
import com.example.marketplace.mapper.ReturnWarwDocItemReqMapper;
import com.example.marketplace.mapper.ReturnWarwDocItemResMapper;
import com.example.marketplace.repostory.ProductRepostory;
import com.example.marketplace.repostory.ReturnWarwDocItemRepostory;
import com.example.marketplace.repostory.ReturnWarwDocRepostory;
import com.example.marketplace.repostory.StoreProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnWarwDocItemServiceImpl implements ReturnWarwDocItemService{
    private final ReturnWarwDocItemReqMapper returnWarwDocItemReqMapper;
    private final ReturnWarwDocItemResMapper returnWarwDocItemResMapper;
    private final ReturnWarwDocItemRepostory returnWarwDocItemRepostory;
    private final ProductRepostory productRepostory;
    private final StoreProductRepostory storeProductRepostory;
    private final ReturnWarwDocRepostory returnWarwDocRepostory;
    @Override
    public List<ReturnWarwDocItemResDTO> getALLReturnWarwDocItem() {
        return returnWarwDocItemResMapper.toDTOs(returnWarwDocItemRepostory.findAll());
    }

    @Override
    public ReturnWarwDocItemResDTO getReturnWarwDocItemById(Long id) {
        return returnWarwDocItemResMapper.toDTO(returnWarwDocItemRepostory.getReferenceById(id));
    }

    @Override
    public ReturnWarwDocItemResDTO createReturnWarwDocItem(ReturnWarwDocItemReqDTO returnWarwDocItemReqDTO) {

        return returnWarwDocItemResMapper.toDTO(returnWarwDocItemRepostory.save(returnWarwDocItemReqMapper.toENTITY(returnWarwDocItemReqDTO)));
    }

    @Override
    public ReturnWarwDocItemResDTO updateReturnWarwDocItem(Long id, ReturnWarwDocItemReqDTO returnWarwDocItemReqDTO) {
        ReturnWarwDocItem returnWarwDocItem = returnWarwDocItemRepostory.getReferenceById(id);
        returnWarwDocItem.setCount(returnWarwDocItemReqDTO.getCount());
        returnWarwDocItem.setProduct(productRepostory.getReferenceById(returnWarwDocItemReqDTO.getProduct_id()));
        returnWarwDocItem.setStoreProduct(storeProductRepostory.getReferenceById(returnWarwDocItemReqDTO.getStoreProduct_id()));
        returnWarwDocItem.setReturnWarwDoc(returnWarwDocRepostory.getReferenceById(returnWarwDocItemReqDTO.getReturnWarwDoc_id()));
        return returnWarwDocItemResMapper.toDTO(returnWarwDocItemRepostory.save(returnWarwDocItem));
    }

    @Override
    public void deleteReturnWarwDocItemById(Long id) {
        returnWarwDocItemRepostory.deleteById(id);
    }
}
