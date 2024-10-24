package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.PettyCashEntity;

public interface PettyCashService {

    public PettyCashEntity save(PettyCashEntity entity);

    public PettyCashEntity update(PettyCashEntity entity);

    public Optional<PettyCashEntity> findById(Long id);

    public List<PettyCashEntity> findAll();

}
