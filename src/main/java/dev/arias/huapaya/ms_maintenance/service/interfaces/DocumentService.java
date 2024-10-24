package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.DocumentEntity;

public interface DocumentService {
    
    public DocumentEntity save(DocumentEntity entity);

    public DocumentEntity update(DocumentEntity entity);

    public Optional<DocumentEntity> findById(Long id);

    public List<DocumentEntity> findAll();

}
