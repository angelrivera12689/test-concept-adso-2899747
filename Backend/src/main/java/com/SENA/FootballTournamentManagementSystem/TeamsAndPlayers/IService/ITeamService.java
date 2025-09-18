package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Team;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.TeamResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.TeamRequestDto;

public interface ITeamService extends IBaseService<Team, TeamResponseDto, TeamRequestDto> {
}
