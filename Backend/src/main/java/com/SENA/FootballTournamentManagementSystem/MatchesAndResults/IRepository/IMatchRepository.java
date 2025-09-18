package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Match;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchRepository extends IBaseRepository<Match, java.util.UUID> {
}
