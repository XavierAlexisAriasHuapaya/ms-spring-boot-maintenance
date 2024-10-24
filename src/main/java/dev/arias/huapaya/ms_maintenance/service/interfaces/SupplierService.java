package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.SupplierEntity;

public interface SupplierService {

    public SupplierEntity save(SupplierEntity entity);

    public SupplierEntity update(SupplierEntity entity);

    public Optional<SupplierEntity> findById(Long id);

    public List<SupplierEntity> findAll();

}
