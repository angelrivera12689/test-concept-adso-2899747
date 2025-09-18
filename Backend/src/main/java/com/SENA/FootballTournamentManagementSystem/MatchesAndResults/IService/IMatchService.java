package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Match;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.MatchResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.MatchRequestDto;

public interface IMatchService extends IBaseService<Match, MatchResponseDto, MatchRequestDto> {
}
