package dev.arias.huapaya.ms_maintenance.persistence.entity;

import java.time.LocalDateTime;
import java.time.LocalDate;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "petty_cash")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PettyCashEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The bank box cannot be null")
    @JoinColumn(name = "bankBoxId")
    @ManyToOne
    private BankBoxEntity bankBox;

    private String openingObservation;

    private String closingObservation;

    @NotNull(message = "The opening date cannot be null")
    private LocalDate openingDate;

    private LocalDate closingDate;

    @NotNull(message = "Opening amount cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Opening amount should have up to 10 digits and 2 decimals place")
    private BigDecimal openingAmount;

    @NotNull(message = "Cash closing cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Cash closing should have up to 10 digits and 2 decimals place")
    private BigDecimal cashClosing;

    @NotNull(message = "Other closing cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Other closing should have up to digits and 2 decimals place")
    private BigDecimal otherClosing;

    @NotNull(message = "The open petty cash cannot be null")
    private Boolean openPettyCash;

    @NotNull(message = "Exchange rate")
    @Digits(integer = 10, fraction = 2, message = "Exchange rate should have up to 10 digits and 2 decimals place")
    private BigDecimal exchangeRate;

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
