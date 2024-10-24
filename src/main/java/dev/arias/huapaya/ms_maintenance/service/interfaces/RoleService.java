package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.RoleEntity;


public interface RoleService {

    public RoleEntity save(RoleEntity entity);

    public RoleEntity update(RoleEntity entity);

    public Optional<RoleEntity> findById(Long id);

    public List<RoleEntity> findAll();
}
