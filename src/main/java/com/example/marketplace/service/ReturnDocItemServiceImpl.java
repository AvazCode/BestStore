package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.ReturnDocItemReqDTO;
import com.example.marketplace.dto.responseDTO.ReturnDocItemResDTO;
import com.example.marketplace.entity.ReturnDocItem;
import com.example.marketplace.mapper.ReturnDocItemReqMapper;
import com.example.marketplace.mapper.ReturnDocItemResMapper;
import com.example.marketplace.repostory.ReturnDocItemRepostory;
import com.example.marketplace.repostory.ReturnDocRepostory;
import com.example.marketplace.repostory.StoreProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnDocItemServiceImpl implements ReturnDocItemService{
    private final ReturnDocItemReqMapper returnDocItemReqMapper;
    private final ReturnDocItemResMapper returnDocItemResMapper;
    private final ReturnDocItemRepostory returnDocItemRepostory;
    private final StoreProductRepostory storeProductRepostory;
    private final ReturnDocRepostory returnDocRepostory;

    @Override
    public List<ReturnDocItemResDTO> getALLReturnDocItem() {
        return returnDocItemResMapper.toDTOs(returnDocItemRepostory.findAll());
    }

    @Override
    public ReturnDocItemResDTO getReturnDocItemById(Long id) {
        return returnDocItemResMapper.toDTO(returnDocItemRepostory.getReferenceById(id));
    }

    @Override
    public ReturnDocItemResDTO createReturnDocItem(ReturnDocItemReqDTO returnDocItemReqDTO) {

        return returnDocItemResMapper.toDTO(returnDocItemRepostory.save(returnDocItemReqMapper.toENTITY(returnDocItemReqDTO)));
    }

    @Override
    public ReturnDocItemResDTO updateReturnDocItem(Long id, ReturnDocItemReqDTO returnDocItemReqDTO) {
        ReturnDocItem returnDocItem = returnDocItemRepostory.getReferenceById(id);
        returnDocItem.setStoreProduct(storeProductRepostory.getReferenceById(returnDocItemReqDTO.getStoreProduct_id()));
        returnDocItem.setCount(returnDocItem.getCount());
        returnDocItem.setReturnDoc(returnDocRepostory.getReferenceById(returnDocItemReqDTO.getReturnDoc_id()));
        return returnDocItemResMapper.toDTO(returnDocItemRepostory.save(returnDocItem));
    }

    @Override
    public void deleteReturnDocItemById(Long id) {
        returnDocItemRepostory.deleteById(id);
    }
}
