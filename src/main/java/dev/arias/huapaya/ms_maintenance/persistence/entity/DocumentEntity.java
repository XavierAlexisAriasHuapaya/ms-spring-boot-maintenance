package dev.arias.huapaya.ms_maintenance.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "documents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String abbreviation;

    @Valid
    @NotNull(message = "documents correlatives cannot be null")
    @JoinColumn(name = "documentId")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<DocumentCorrelativeEntity> documentsCorrelatives;

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
