package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefereeResponseDto {
    private UUID id;
    private String name;
}
