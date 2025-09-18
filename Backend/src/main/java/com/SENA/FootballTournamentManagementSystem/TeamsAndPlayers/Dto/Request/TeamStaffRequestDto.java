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
public class TeamStaffRequestDto {
    private String name;
    private String role;
    private UUID teamId;
}
