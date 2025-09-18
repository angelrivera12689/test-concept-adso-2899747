package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Player;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.PlayerResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.PlayerRequestDto;

public interface IPlayerService extends IBaseService<Player, PlayerResponseDto, PlayerRequestDto> {
}
