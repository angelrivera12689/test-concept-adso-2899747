package com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Request;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentRequestDto {
    private String code;
    private String name;
    private Date startDate;
    private Date endDate;
}
