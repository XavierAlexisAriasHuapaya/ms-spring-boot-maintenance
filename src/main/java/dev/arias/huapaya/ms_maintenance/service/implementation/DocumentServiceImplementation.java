package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.DocumentCorrelativeEntity;
import dev.arias.huapaya.ms_maintenance.persistence.entity.DocumentEntity;
import dev.arias.huapaya.ms_maintenance.persistence.entity.StoreEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.DocumentRepository;
import dev.arias.huapaya.ms_maintenance.persistence.repository.StoreRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.MasterException;
import dev.arias.huapaya.ms_maintenance.service.exception.StoreException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.DocumentService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DocumentServiceImplementation implements DocumentService {

    private final DocumentRepository documentRepository;

    private final StoreRepository storeRepository;

    @Transactional(readOnly = false)
    @Override
    public DocumentEntity save(DocumentEntity entity) {
        DocumentCorrelativeEntity documentCorrelative = null;
        List<DocumentCorrelativeEntity> listDocumentsCorrelatives = null;
        List<StoreEntity> storeList = this.storeRepository.findAll();

        if (storeList.size() == 0) {
            throw new StoreException("Store empty");
        }

        listDocumentsCorrelatives = new ArrayList<>();        
        for (int i = 0; i < storeList.size(); i++) {
            documentCorrelative = new DocumentCorrelativeEntity();
            documentCorrelative.setStore(storeList.get(i));
            documentCorrelative.setSerie(entity.getAbbreviation());
            documentCorrelative.setIssued(0);
            listDocumentsCorrelatives.add(documentCorrelative);
        }

        entity.setDocumentsCorrelatives(listDocumentsCorrelatives);
        return this.documentRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public DocumentEntity update(DocumentEntity entity) {
        Optional<DocumentEntity> documentUpdate = this.findById(entity.getId());
        if (documentUpdate.isPresent()) {
            documentUpdate.get().setName(entity.getName());
            documentUpdate.get().setAbbreviation(entity.getAbbreviation());
        } else {
            throw new MasterException("Document not found");
        }
        return this.documentRepository.save(documentUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DocumentEntity> findById(Long id) {
        return this.documentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<DocumentEntity> findAll() {
        return this.documentRepository.findAll();
    }

}
