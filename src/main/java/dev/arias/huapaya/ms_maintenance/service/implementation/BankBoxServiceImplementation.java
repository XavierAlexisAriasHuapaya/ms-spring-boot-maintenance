package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.BankBoxEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.BankBoxRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.BankBoxException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.BankBoxService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BankBoxServiceImplementation implements BankBoxService {

    private final BankBoxRepository bankBoxRepository;

    @Transactional(readOnly = false)
    @Override
    public BankBoxEntity save(BankBoxEntity entity) {
        return this.bankBoxRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public BankBoxEntity update(BankBoxEntity entity) {
        Optional<BankBoxEntity> bankBoxUpdate = this.findById(entity.getId());
        if (bankBoxUpdate.isPresent()) {
            bankBoxUpdate.get().setStore(entity.getStore());
            bankBoxUpdate.get().setName(entity.getName());
        } else {
            throw new BankBoxException("Bank box not found");
        }
        return this.bankBoxRepository.save(bankBoxUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<BankBoxEntity> findById(Long id) {
        return this.bankBoxRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BankBoxEntity> findAll() {
        return this.bankBoxRepository.findAll();
    }

}
