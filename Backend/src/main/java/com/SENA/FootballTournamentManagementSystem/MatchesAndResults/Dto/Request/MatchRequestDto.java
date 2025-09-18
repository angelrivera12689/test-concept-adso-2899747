package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.UUID;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDto {
    private UUID tournamentId;
    private UUID homeTeamId;
    private UUID awayTeamId;
    private UUID stadiumId;
    private UUID refereeId;
    private LocalDateTime date;
}
