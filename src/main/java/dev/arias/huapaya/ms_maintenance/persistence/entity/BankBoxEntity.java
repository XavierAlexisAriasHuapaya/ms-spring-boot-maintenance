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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "bank_boxes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankBoxEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The store cannot be null")
    @JoinColumn(name = "storeId")
    @ManyToOne
    private StoreEntity store;

    @NotEmpty(message = "Name is empty")
    private String name;

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
