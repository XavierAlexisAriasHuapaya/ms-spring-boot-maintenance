package dev.arias.huapaya.ms_maintenance.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.arias.huapaya.ms_maintenance.persistence.entity.PettyCashEntity;

public interface PettyCashRepository extends JpaRepository<PettyCashEntity, Long> {

}
