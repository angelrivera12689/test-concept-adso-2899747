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
public class PlayerResponseDto {
    private UUID id;
    private String name;
    private Integer jerseyNumber;
    private String position;
    private UUID teamId;
}
