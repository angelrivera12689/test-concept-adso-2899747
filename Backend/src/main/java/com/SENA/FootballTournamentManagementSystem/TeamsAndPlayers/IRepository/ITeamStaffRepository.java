package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.TeamStaff;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamStaffRepository extends IBaseRepository<TeamStaff, java.util.UUID> {
}
