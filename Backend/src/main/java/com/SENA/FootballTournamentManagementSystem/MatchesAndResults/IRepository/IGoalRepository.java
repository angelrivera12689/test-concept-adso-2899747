package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Goal;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoalRepository extends IBaseRepository<Goal, java.util.UUID> {
}
