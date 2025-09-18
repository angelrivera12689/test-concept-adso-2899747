package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private UUID id;
    private String name;
    private UUID tournamentId;
    private UUID coachId;
}
