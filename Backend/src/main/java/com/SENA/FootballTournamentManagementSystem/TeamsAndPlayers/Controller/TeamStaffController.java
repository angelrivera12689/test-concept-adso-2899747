package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Controller;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.TeamStaffRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.TeamStaffResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.ITeamStaffService;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/team-staff")
@RequiredArgsConstructor
public class TeamStaffController {
    private final ITeamStaffService teamStaffService;

    @GetMapping
    public ApiResponseDto<List<TeamStaffResponseDto>> getAll() throws Exception {
        return ApiResponseDto.success(teamStaffService.all());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<TeamStaffResponseDto> getById(@PathVariable String id) throws Exception {
        return teamStaffService.findById(id)
                .map(ApiResponseDto::success)
                .orElse(ApiResponseDto.notFound("Team staff not found"));
    }

    @PostMapping
    public ApiResponseDto<TeamStaffResponseDto> create(@RequestBody TeamStaffRequestDto dto) throws Exception {
        return ApiResponseDto.success(teamStaffService.save(dto));
    }

    @PutMapping("/{id}")
    public ApiResponseDto<Void> update(@PathVariable String id, @RequestBody TeamStaffRequestDto dto) throws Exception {
        teamStaffService.update(id, dto);
        return ApiResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<Void> delete(@PathVariable String id) throws Exception {
        teamStaffService.delete(id);
        return ApiResponseDto.success();
    }
}
