package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.DocumentReqDTO;
import com.example.marketplace.dto.responseDTO.DocumentResDTO;
import com.example.marketplace.entity.Document;
import com.example.marketplace.mapper.DocumentReqMapper;
import com.example.marketplace.mapper.DocumentResMapper;
import com.example.marketplace.repostory.CompanyRepostory;
import com.example.marketplace.repostory.DocumentRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
    private final DocumentRepostory documentRepostory;
    private final DocumentReqMapper documentReqMapper;
    private final DocumentResMapper documentResMapper;
    private final CompanyRepostory companyRepostory;
    @Override
    public List<DocumentResDTO> getALLDocument() {
        return documentResMapper.toDTOs(documentRepostory.findAll());
    }

    @Override
    public DocumentResDTO getDocumentById(Long id) {

        return documentResMapper.toDTO(documentRepostory.getReferenceById(id));
    }

    @Override
    public DocumentResDTO createDocument(DocumentReqDTO documentReqDTO) {

        return documentResMapper.toDTO(documentRepostory.save(documentReqMapper.toENTITY(documentReqDTO)));
    }

    @Override
    public DocumentResDTO updateDocument(Long id, DocumentReqDTO documentReqDTO) {
        Document document = documentRepostory.getReferenceById(id);
        document.setDate(documentReqDTO.getDate());
        document.setDocument_number(documentReqDTO.getDocument_number());
        document.setCompany(companyRepostory.getReferenceById(documentReqDTO.getCompany_id()));
        return documentResMapper.toDTO(documentRepostory.save(document));
    }

    @Override
    public void deleteDocumentById(Long id) {
        documentRepostory.deleteById(id);
    }
}

