package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.TypeOperationEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.TypeOperationRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.TypeOperationException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.TypeOperationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TypeOperationServiceImplementation implements TypeOperationService {

    private final TypeOperationRepository typeOperationRepository;

    @Transactional(readOnly = false)
    @Override
    public TypeOperationEntity save(TypeOperationEntity entity) {
        return this.typeOperationRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public TypeOperationEntity update(TypeOperationEntity entity) {
        Optional<TypeOperationEntity> typeOperationUpdate = this.findById(entity.getId());
        if (typeOperationUpdate.isPresent()) {
            typeOperationUpdate.get().setName(entity.getName());
            typeOperationUpdate.get().setIncome(entity.getIncome());
        } else {
            throw new TypeOperationException("Type Operation not found");
        }
        return this.typeOperationRepository.save(typeOperationUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TypeOperationEntity> findById(Long id) {
        return this.typeOperationRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TypeOperationEntity> findAll() {
        return this.typeOperationRepository.findAll();
    }

}
