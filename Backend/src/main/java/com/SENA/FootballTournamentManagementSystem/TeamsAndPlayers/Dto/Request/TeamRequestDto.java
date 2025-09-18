package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDto {
    private String name;
    private UUID tournamentId;
    private UUID coachId;
}
