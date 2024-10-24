package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.StoreEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.StoreRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.StoreException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.StoreService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StoreServiceImplementation implements StoreService{

    private final StoreRepository storeRepository;

    @Transactional(readOnly = false)
    @Override
    public StoreEntity save(StoreEntity entity) {
        return this.storeRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public StoreEntity update(StoreEntity entity) {
        Optional<StoreEntity> storeUpdate = this.findById(entity.getId());
        if (storeUpdate.isPresent()) {
            storeUpdate.get().setCurrency(entity.getCurrency());
            storeUpdate.get().setName(entity.getName());
            storeUpdate.get().setAddress(entity.getAddress());
            storeUpdate.get().setPhone(entity.getPhone());
            storeUpdate.get().setLogo(entity.getLogo());
        } else {
            throw new StoreException("Store not found");
        }
        return this.storeRepository.save(storeUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<StoreEntity> findById(Long id) {
        return this.storeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StoreEntity> findAll() {
        return this.storeRepository.findAll();
    }
    
}
