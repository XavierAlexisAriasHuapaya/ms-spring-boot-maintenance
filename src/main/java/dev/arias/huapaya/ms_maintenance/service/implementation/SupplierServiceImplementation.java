package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.SupplierEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.SupplierRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.StoreException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.SupplierService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SupplierServiceImplementation implements SupplierService {
    
    private final SupplierRepository supplierRepository;
    
    @Transactional(readOnly = false)
    @Override
    public SupplierEntity save(SupplierEntity entity) {
        return this.supplierRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public SupplierEntity update(SupplierEntity entity) {
        Optional<SupplierEntity> supplierUpdate = this.findById(entity.getId());
        if (supplierUpdate.isPresent()) {
            supplierUpdate.get().setTypeSupplier(entity.getTypeSupplier());
            supplierUpdate.get().setCompanieName(entity.getCompanieName());
            supplierUpdate.get().setIdentityNumber(entity.getIdentityNumber());
            supplierUpdate.get().setAddress(entity.getAddress());
            supplierUpdate.get().setPhone(entity.getPhone());
            supplierUpdate.get().setWeb(entity.getWeb());
        } else {
            throw new StoreException("Type Person not found");
        }
        return this.supplierRepository.save(supplierUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SupplierEntity> findById(Long id) {
        return this.supplierRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SupplierEntity> findAll() {
        return this.supplierRepository.findAll();
    }
    
}
