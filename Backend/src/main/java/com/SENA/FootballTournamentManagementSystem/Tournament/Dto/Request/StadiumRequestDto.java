package com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Request;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StadiumRequestDto {
    private String name;
    private String location;
    private Integer capacity;
}
