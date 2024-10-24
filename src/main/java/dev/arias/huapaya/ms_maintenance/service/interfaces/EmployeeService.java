package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.EmployeeEntity;

public interface EmployeeService {

    public EmployeeEntity save(EmployeeEntity entity);

    public EmployeeEntity update(EmployeeEntity entity);

    public Optional<EmployeeEntity> findById(Long id);

    public List<EmployeeEntity> findAll();

}
