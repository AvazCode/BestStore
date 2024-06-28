package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.DocItemsReqDTO;
import com.example.marketplace.dto.responseDTO.DocItemsResDTO;
import com.example.marketplace.entity.DocItems;
import com.example.marketplace.mapper.DocItemsReqMapper;
import com.example.marketplace.mapper.DocItemsResMapper;
import com.example.marketplace.repostory.DocItemsRepostory;
import com.example.marketplace.repostory.DocumentRepostory;
import com.example.marketplace.repostory.ProductRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocItemsServiceImpl implements DocItemsService{
    private final DocItemsRepostory docItemsRepostory;
    private final DocItemsReqMapper docItemsReqMapper;
    private final DocItemsResMapper docItemsResMapper;
    private final ProductRepostory productRepostory;
    private final DocumentRepostory documentRepostory;
    @Override
    public List<DocItemsResDTO> getALLDocItems() {
        return docItemsResMapper.toDTOs(docItemsRepostory.findAll());
    }

    @Override
    public DocItemsResDTO getDocItemsById(Long id) {

        return docItemsResMapper.toDTO(docItemsRepostory.getReferenceById(id));
    }

    @Override
    public DocItemsResDTO createDocItems(DocItemsReqDTO docItemsReqDTO) {
        System.out.println(docItemsReqMapper.toENTITY(docItemsReqDTO).toString());
        return docItemsResMapper.toDTO(docItemsRepostory.save(docItemsReqMapper.toENTITY(docItemsReqDTO)));
    }

    @Override
    public DocItemsResDTO updateDocItems(Long id, DocItemsReqDTO docItemsReqDTO) {
        DocItems docItems = docItemsRepostory.getReferenceById(id);
        docItems.setCount(docItemsReqDTO.getCount());
        docItems.setCome_price(docItemsReqDTO.getCome_price());
        docItems.setDocument(documentRepostory.getReferenceById(docItemsReqDTO.getDocument_id()));
        docItems.setProduct(productRepostory.getReferenceById(docItemsReqDTO.getProduct_id()));
        return docItemsResMapper.toDTO(docItemsRepostory.save(docItems));
    }

    @Override
    public void deleteDocItemsById(Long id) {
        documentRepostory.deleteById(docItemsRepostory.getReferenceById(id).getDocument().getId());
        docItemsRepostory.deleteById(id);
    }
}

