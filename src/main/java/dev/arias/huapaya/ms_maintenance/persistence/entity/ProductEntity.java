package dev.arias.huapaya.ms_maintenance.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unitOfMeasureId")
    private MasterDetailEntity unitOfMeasure;

    @NotNull(message = "The category cannot be null")
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private MasterDetailEntity category;

    @NotNull(message = "The model cannot be null")
    @ManyToOne
    @JoinColumn(name = "modelId")
    private MasterDetailEntity model;

    @NotNull(message = "The brand cannot be null")
    @ManyToOne
    @JoinColumn(name = "brandId")
    private MasterDetailEntity brand;

    @NotEmpty(message = "Name is empty")
    private String name;

    private String description;

    @NotNull(message = "Unit price cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Unit price should have up to 10 digits and 2 decimals places")
    private BigDecimal unitPrice;

    @NotNull(message = "Purchase price cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Purchase price should have un to 10 digits and 2 decimals places")
    private BigDecimal purchasePrice;

    @NotNull(message = "The minmum stock cannot be null")
    @Min(value = 5, message = "Minimum stock must be at least 5")
    private Integer minimumStock;

    private String image;

    @Valid
    @NotNull(message = "products stores cannot be null")
    @JoinColumn(name = "productId")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<ProductStoreEntity> productsStores;

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
