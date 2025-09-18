package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Service;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.TeamRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.TeamResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Team;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository.ITeamRepository;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {
    private final ITeamRepository teamRepository;

    @Override
    public List<TeamResponseDto> all() {
        List<Team> teams = teamRepository.findAll();
        List<TeamResponseDto> dtos = new ArrayList<>();
        for (Team team : teams) {
            dtos.add(TeamResponseDto.builder()
                    .id(team.getId())
                    .name(team.getName())
                    .tournamentId(team.getTournamentId())
                    .coachId(team.getCoachId())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<TeamResponseDto> findById(String id) {
        return teamRepository.findById(UUID.fromString(id))
                .map(team -> TeamResponseDto.builder()
                        .id(team.getId())
                        .name(team.getName())
                        .tournamentId(team.getTournamentId())
                        .coachId(team.getCoachId())
                        .build());
    }

    @Override
    public TeamResponseDto save(TeamRequestDto dto) {
        Team team = Team.builder()
                .name(dto.getName())
                .tournamentId(dto.getTournamentId())
                .coachId(dto.getCoachId())
                .build();
        Team saved = teamRepository.save(team);
        return TeamResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .tournamentId(saved.getTournamentId())
                .coachId(saved.getCoachId())
                .build();
    }

    @Override
    public void update(String id, TeamRequestDto dto) {
        Team team = teamRepository.findById(UUID.fromString(id)).orElseThrow();
        team.setName(dto.getName());
        team.setTournamentId(dto.getTournamentId());
        team.setCoachId(dto.getCoachId());
        teamRepository.save(team);
    }

    @Override
    public void delete(String id) {
        teamRepository.deleteById(UUID.fromString(id));
    }
}
