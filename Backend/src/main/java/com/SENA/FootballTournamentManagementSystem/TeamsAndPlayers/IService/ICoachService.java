package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Coach;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.CoachResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.CoachRequestDto;

public interface ICoachService extends IBaseService<Coach, CoachResponseDto, CoachRequestDto> {
}
