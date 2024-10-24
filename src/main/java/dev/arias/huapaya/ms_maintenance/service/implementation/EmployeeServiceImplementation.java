package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.EmployeeEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.EmployeeRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.MasterException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.EmployeeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = false)
    @Override
    public EmployeeEntity save(EmployeeEntity entity) {
        return this.employeeRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public EmployeeEntity update(EmployeeEntity entity) {
        Optional<EmployeeEntity> employeeUpdate = this.findById(entity.getId());
        if (employeeUpdate.isPresent()) {
            employeeUpdate.get().setTypePerson(entity.getTypePerson());
            employeeUpdate.get().setIdentityNumber(entity.getIdentityNumber());
            employeeUpdate.get().setUser(entity.getUser());
            employeeUpdate.get().setFirstName(entity.getFirstName());
            employeeUpdate.get().setLastName(entity.getLastName());
            employeeUpdate.get().setAddress(entity.getAddress());
            employeeUpdate.get().setPhone(entity.getPhone());
        } else {
            throw new MasterException("Employee not found");
        }
        return this.employeeRepository.save(employeeUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmployeeEntity> findAll() {
        return this.employeeRepository.findAll();
    }

}
