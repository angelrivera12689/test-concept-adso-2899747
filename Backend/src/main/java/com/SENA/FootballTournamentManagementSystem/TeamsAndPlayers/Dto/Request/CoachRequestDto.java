package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoachRequestDto {
    private String name;
}
