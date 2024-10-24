package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.ClientEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.ClientRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.MasterException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.ClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;

    @Transactional(readOnly = false)
    @Override
    public ClientEntity save(ClientEntity entity) {
        return this.clientRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public ClientEntity update(ClientEntity entity) {
        Optional<ClientEntity> clientUpdate = this.findById(entity.getId());
        if (clientUpdate.isPresent()) {
            clientUpdate.get().setTypePerson(entity.getTypePerson());
            clientUpdate.get().setGender(entity.getGender());
            clientUpdate.get().setFirstName(entity.getFirstName());
            clientUpdate.get().setLastName(entity.getLastName());
            clientUpdate.get().setBirthOrAnniversary(entity.getBirthOrAnniversary());
            clientUpdate.get().setAddress(entity.getAddress());
            clientUpdate.get().setEmail(entity.getEmail());
            clientUpdate.get().setOccupation(entity.getOccupation());
            clientUpdate.get().setObservation(entity.getObservation());
        } else {
            throw new MasterException("Client not found");
        }
        return this.clientRepository.save(clientUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ClientEntity> findById(Long id) {
        return this.clientRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientEntity> findAll() {
        return this.clientRepository.findAll();
    }

}
