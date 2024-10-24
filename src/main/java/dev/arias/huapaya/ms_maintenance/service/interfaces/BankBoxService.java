package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.BankBoxEntity;

public interface BankBoxService {

    public BankBoxEntity save(BankBoxEntity entity);

    public BankBoxEntity update(BankBoxEntity entity);

    public Optional<BankBoxEntity> findById(Long id);

    public List<BankBoxEntity> findAll();

}
