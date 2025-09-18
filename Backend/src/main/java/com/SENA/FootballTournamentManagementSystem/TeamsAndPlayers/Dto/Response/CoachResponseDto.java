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
public class CoachResponseDto {
    private UUID id;
    private String name;
}
