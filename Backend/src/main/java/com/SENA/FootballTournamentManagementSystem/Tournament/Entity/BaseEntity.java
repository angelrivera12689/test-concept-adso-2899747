package com.SENA.FootballTournamentManagementSystem.Tournament.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @Column(name = "deleted_by")
    private String deletedBy;

    // Se ejecuta al insertar
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.status = "active"; // por defecto activo
    }

    // Se ejecuta al actualizar
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
