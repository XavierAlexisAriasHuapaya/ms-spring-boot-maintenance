package dev.arias.huapaya.ms_maintenance.persistence.entity;

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

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The type person cannot be null")
    @JoinColumn(name = "typePersonId")
    @ManyToOne
    private MasterDetailEntity TypePerson;

    @NotEmpty(message = "Identity number is empty")
    private String identityNumber;

    @NotNull(message = "The gender cannot be null")
    @JoinColumn(name = "genderId")
    @ManyToOne
    private MasterDetailEntity Gender;

    @NotEmpty(message = "First name is empty")
    private String firstName;

    @NotEmpty(message = "Last name is empty")
    private String lastName;

    private LocalDate birthOrAnniversary;

    private String address;

    private String email;

    private String occupation;

    private String observation;

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
