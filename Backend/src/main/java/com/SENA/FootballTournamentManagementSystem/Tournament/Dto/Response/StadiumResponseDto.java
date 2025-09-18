package com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Response;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.BaseDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StadiumResponseDto extends BaseDto {
    private String name;
    private String location;
    private Integer capacity;
}
