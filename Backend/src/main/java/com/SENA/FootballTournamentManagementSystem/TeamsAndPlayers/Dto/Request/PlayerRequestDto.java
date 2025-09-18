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
public class PlayerRequestDto {
    private String name;
    private Integer jerseyNumber;
    private String position;
    private UUID teamId;
}
