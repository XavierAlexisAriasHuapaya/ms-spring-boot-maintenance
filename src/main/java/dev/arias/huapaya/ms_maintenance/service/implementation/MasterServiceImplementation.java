package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.MasterEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.MasterRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.MasterException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.MasterService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MasterServiceImplementation implements MasterService {

    private final MasterRepository masterRepository;

    @Transactional(readOnly = false)
    @Override
    public MasterEntity save(MasterEntity entity) {
        return this.masterRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public MasterEntity update(MasterEntity entity) {
        Optional<MasterEntity> masterUpdate = this.findById(entity.getId());
        if (masterUpdate.isPresent()) {
            masterUpdate.get().setDescription(entity.getDescription());
            masterUpdate.get().setStatus(entity.getStatus());
        } else {
            throw new MasterException("Master not found");
        }
        return this.masterRepository.save(masterUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MasterEntity> findById(Long id) {
        return this.masterRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MasterEntity> findAll() {
        return this.masterRepository.findAll();
    }

}
