package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.RoleEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.RoleRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.RoleException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.RoleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;

    @Transactional(readOnly = false)
    @Override
    public RoleEntity save(RoleEntity entity) {
        return this.roleRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public RoleEntity update(RoleEntity entity) {
        Optional<RoleEntity> storeUpdate = this.findById(entity.getId());
        if (storeUpdate.isPresent()) {
            storeUpdate.get().setDescription(entity.getDescription());
        } else {
            throw new RoleException("Store not found");
        }
        return this.roleRepository.save(storeUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<RoleEntity> findById(Long id) {
        return this.roleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleEntity> findAll() {
        return this.roleRepository.findAll();
    }

}
