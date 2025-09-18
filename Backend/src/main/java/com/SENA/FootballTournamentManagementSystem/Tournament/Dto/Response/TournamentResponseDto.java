package com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Response;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.UUID;

import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.BaseDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentResponseDto extends BaseDto {
    private String code;
    private String name;
    private Date startDate;
    private Date endDate;
}
