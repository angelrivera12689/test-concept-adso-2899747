package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Service;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.TeamStaffRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.TeamStaffResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.TeamStaff;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository.ITeamStaffRepository;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.ITeamStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TeamStaffService implements ITeamStaffService {
    private final ITeamStaffRepository teamStaffRepository;

    @Override
    public List<TeamStaffResponseDto> all() {
        List<TeamStaff> staffList = teamStaffRepository.findAll();
        List<TeamStaffResponseDto> dtos = new ArrayList<>();
        for (TeamStaff staff : staffList) {
            dtos.add(TeamStaffResponseDto.builder()
                    .id(staff.getId())
                    .name(staff.getName())
                    .role(staff.getRole())
                    .teamId(staff.getTeamId())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<TeamStaffResponseDto> findById(String id) {
        return teamStaffRepository.findById(UUID.fromString(id))
                .map(staff -> TeamStaffResponseDto.builder()
                        .id(staff.getId())
                        .name(staff.getName())
                        .role(staff.getRole())
                        .teamId(staff.getTeamId())
                        .build());
    }

    @Override
    public TeamStaffResponseDto save(TeamStaffRequestDto dto) {
        TeamStaff staff = TeamStaff.builder()
                .name(dto.getName())
                .role(dto.getRole())
                .teamId(dto.getTeamId())
                .build();
        TeamStaff saved = teamStaffRepository.save(staff);
        return TeamStaffResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .role(saved.getRole())
                .teamId(saved.getTeamId())
                .build();
    }

    @Override
    public void update(String id, TeamStaffRequestDto dto) {
        TeamStaff staff = teamStaffRepository.findById(UUID.fromString(id)).orElseThrow();
        staff.setName(dto.getName());
        staff.setRole(dto.getRole());
        staff.setTeamId(dto.getTeamId());
        teamStaffRepository.save(staff);
    }

    @Override
    public void delete(String id) {
        teamStaffRepository.deleteById(UUID.fromString(id));
    }
}
