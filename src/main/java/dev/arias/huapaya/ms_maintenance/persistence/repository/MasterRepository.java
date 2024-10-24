package dev.arias.huapaya.ms_maintenance.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.ms_maintenance.persistence.entity.MasterEntity;

@Repository
public interface MasterRepository extends JpaRepository<MasterEntity, Long> {

}
