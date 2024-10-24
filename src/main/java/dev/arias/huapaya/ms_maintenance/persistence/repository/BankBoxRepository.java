package dev.arias.huapaya.ms_maintenance.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.ms_maintenance.persistence.entity.BankBoxEntity;

@Repository
public interface BankBoxRepository extends JpaRepository<BankBoxEntity, Long>{
    
}
