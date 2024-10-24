package dev.arias.huapaya.ms_maintenance.service.implementation;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.ms_maintenance.persistence.entity.ProductEntity;
import dev.arias.huapaya.ms_maintenance.persistence.entity.ProductStoreEntity;
import dev.arias.huapaya.ms_maintenance.persistence.entity.StoreEntity;
import dev.arias.huapaya.ms_maintenance.persistence.repository.ProductRepository;
import dev.arias.huapaya.ms_maintenance.persistence.repository.StoreRepository;
import dev.arias.huapaya.ms_maintenance.service.exception.MasterException;
import dev.arias.huapaya.ms_maintenance.service.exception.StoreException;
import dev.arias.huapaya.ms_maintenance.service.interfaces.ProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    private final StoreRepository storeRepository;

    @Transactional(readOnly = false)
    @Override
    public ProductEntity save(ProductEntity entity) {

        ProductStoreEntity productStore = null;
        List<ProductStoreEntity> listProductStore = null;
        List<StoreEntity> storeList = this.storeRepository.findAll();

        if (storeList.size() == 0) {
            throw new StoreException("Store empty");
        }

        listProductStore = new ArrayList<>();
        for (int i = 0; i < storeList.size(); i++) {
            productStore = new ProductStoreEntity();
            productStore.setStore(storeList.get(i));
            productStore.setStock(0);
            productStore.setSalePrice(new BigDecimal("100.00"));
            productStore.setPurchasePrice(new BigDecimal("29.99"));
            listProductStore.add(productStore);
        }

        entity.setProductsStores(listProductStore);
        return this.productRepository.save(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public ProductEntity update(ProductEntity entity) {
        Optional<ProductEntity> productUpdate = this.findById(entity.getId());
        if (productUpdate.isPresent()) {
            productUpdate.get().setUnitOfMeasure(entity.getUnitOfMeasure());
            productUpdate.get().setCategory(entity.getCategory());
            productUpdate.get().setModel(entity.getModel());
            productUpdate.get().setBrand(entity.getBrand());
            productUpdate.get().setName(entity.getName());
            productUpdate.get().setDescription(entity.getDescription());
            productUpdate.get().setUnitPrice(entity.getUnitPrice());
            productUpdate.get().setPurchasePrice(entity.getPurchasePrice());
            productUpdate.get().setMinimumStock(entity.getMinimumStock());
            productUpdate.get().setImage(entity.getImage());
        } else {
            throw new MasterException("Product not found");
        }
        return this.productRepository.save(productUpdate.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ProductEntity> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductEntity> findAll() {
        return this.productRepository.findAll();
    }

}
