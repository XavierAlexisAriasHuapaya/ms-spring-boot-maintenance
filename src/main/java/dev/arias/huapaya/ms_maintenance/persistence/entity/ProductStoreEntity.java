package dev.arias.huapaya.ms_maintenance.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products_stores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStoreEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The store cannot be null")
    @JoinColumn(name = "storeId")
    @ManyToOne
    private StoreEntity store;

    @NotNull(message = "The stock cannot be null")
    @Min(value = 0, message = "Stock must be at least 0")
    private Integer stock;

    @NotNull(message = "The sale price cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Sale price should have up to 10 digits and 2 decimals place")
    private BigDecimal salePrice;

    @NotNull(message = "The purchase price cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Purchase price should have up to 10 digits and 2 decimals place")
    private BigDecimal purchasePrice;

    @Column(updatable = false)
    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private Boolean status;

    @PrePersist
    private void prePersist() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.status = true;
    }

    @PreUpdate
    private void preUpdate() {
        this.updated_at = LocalDateTime.now();
    }
}
