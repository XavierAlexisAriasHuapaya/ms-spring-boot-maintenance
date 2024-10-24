package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.TypeOperationEntity;

public interface TypeOperationService {

    public TypeOperationEntity save(TypeOperationEntity entity);

    public TypeOperationEntity update(TypeOperationEntity entity);

    public Optional<TypeOperationEntity> findById(Long id);

    public List<TypeOperationEntity> findAll();

}
