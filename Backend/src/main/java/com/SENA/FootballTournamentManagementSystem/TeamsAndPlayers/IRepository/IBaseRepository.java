package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.BaseEntity;

@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
    // Métodos comunes para repositorios
}
