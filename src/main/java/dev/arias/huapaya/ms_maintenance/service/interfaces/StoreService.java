package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.StoreEntity;

public interface StoreService {

    public StoreEntity save(StoreEntity entity);

    public StoreEntity update(StoreEntity entity);

    public Optional<StoreEntity> findById(Long id);

    public List<StoreEntity> findAll();
}
