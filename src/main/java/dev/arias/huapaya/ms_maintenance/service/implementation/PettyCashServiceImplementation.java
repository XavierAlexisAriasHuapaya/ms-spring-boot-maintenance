package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.PettyCashEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.PettyCashRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.MasterException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.PettyCashService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PettyCashServiceImplementation implements PettyCashService {

    private final PettyCashRepository pettyCashRepository;

    @Transactional(readOnly = false)
    @Override
    public PettyCashEntity save(PettyCashEntity entity) {
        return this.pettyCashRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public PettyCashEntity update(PettyCashEntity entity) {
        Optional<PettyCashEntity> pettyCashUpdate = this.findById(entity.getId());
        if (pettyCashUpdate.isPresent()) {
            pettyCashUpdate.get().setBankBox(entity.getBankBox());
            pettyCashUpdate.get().setOpeningObservation(entity.getOpeningObservation());
            pettyCashUpdate.get().setClosingObservation(entity.getClosingObservation());
            pettyCashUpdate.get().setOpeningDate(entity.getOpeningDate());
            pettyCashUpdate.get().setClosingDate(entity.getClosingDate());
            pettyCashUpdate.get().setOpeningAmount(entity.getOpeningAmount());
            pettyCashUpdate.get().setCashClosing(entity.getCashClosing());
            pettyCashUpdate.get().setOtherClosing(entity.getOtherClosing());
            pettyCashUpdate.get().setOpenPettyCash(entity.getOpenPettyCash());
            pettyCashUpdate.get().setExchangeRate(entity.getExchangeRate());
        } else {
            throw new MasterException("Petty Cash not found");
        }
        return this.pettyCashRepository.save(pettyCashUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PettyCashEntity> findById(Long id) {
        return this.pettyCashRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PettyCashEntity> findAll() {
        return this.pettyCashRepository.findAll();
    }

}
