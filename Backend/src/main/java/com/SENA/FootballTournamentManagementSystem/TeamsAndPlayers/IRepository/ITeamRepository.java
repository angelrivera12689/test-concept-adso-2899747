package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends IBaseRepository<Team, java.util.UUID> {
}
