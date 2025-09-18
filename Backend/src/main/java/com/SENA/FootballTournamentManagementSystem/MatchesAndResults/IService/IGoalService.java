package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Goal;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.GoalResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.GoalRequestDto;

public interface IGoalService extends IBaseService<Goal, GoalResponseDto, GoalRequestDto> {
}
