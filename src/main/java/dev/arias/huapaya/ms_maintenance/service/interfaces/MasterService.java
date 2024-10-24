package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.MasterEntity;

public interface MasterService {

    public MasterEntity save(MasterEntity entity);

    public MasterEntity update(MasterEntity entity);

    public Optional<MasterEntity> findById(Long id);

    public List<MasterEntity> findAll();

}
