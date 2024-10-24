package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.ClientEntity;

public interface ClientService {

    public ClientEntity save(ClientEntity entity);

    public ClientEntity update(ClientEntity entity);

    public Optional<ClientEntity> findById(Long id);

    public List<ClientEntity> findAll();

}
