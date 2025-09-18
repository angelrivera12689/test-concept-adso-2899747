package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends IBaseRepository<Player, java.util.UUID> {
}
