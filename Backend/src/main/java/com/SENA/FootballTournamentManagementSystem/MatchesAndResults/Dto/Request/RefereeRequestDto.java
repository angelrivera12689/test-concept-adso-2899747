package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefereeRequestDto {
    private String name;
}
