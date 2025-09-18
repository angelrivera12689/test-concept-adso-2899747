package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Referee;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefereeRepository extends IBaseRepository<Referee, java.util.UUID> {
}
