package dev.arias.huapaya.ms_maintenance.service.interfaces;

import java.util.List;
import java.util.Optional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.ProductEntity;

public interface ProductService {

    public ProductEntity save(ProductEntity entity);

    public ProductEntity update(ProductEntity entity);

    public Optional<ProductEntity> findById(Long id);

    public List<ProductEntity> findAll();

}
