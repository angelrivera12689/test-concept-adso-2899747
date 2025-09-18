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
public class PenaltyResponseDto {
    private UUID id;
    private UUID matchId;
    private UUID playerId;
    private String penaltyType;
    private Integer minute;
    private String reason;
}
