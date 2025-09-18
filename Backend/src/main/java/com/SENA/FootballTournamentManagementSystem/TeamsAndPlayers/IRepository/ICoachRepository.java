package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Coach;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepository extends IBaseRepository<Coach, java.util.UUID> {
}
