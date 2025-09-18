package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Controller;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.TeamRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.TeamResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.ITeamService;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {
    private final ITeamService teamService;

    @GetMapping
    public ApiResponseDto<List<TeamResponseDto>> getAll() throws Exception {
        return ApiResponseDto.success(teamService.all());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<TeamResponseDto> getById(@PathVariable String id) throws Exception {
        return teamService.findById(id)
                .map(ApiResponseDto::success)
                .orElse(ApiResponseDto.notFound("Team not found"));
    }

    @PostMapping
    public ApiResponseDto<TeamResponseDto> create(@RequestBody TeamRequestDto dto) throws Exception {
        return ApiResponseDto.success(teamService.save(dto));
    }

    @PutMapping("/{id}")
    public ApiResponseDto<Void> update(@PathVariable String id, @RequestBody TeamRequestDto dto) throws Exception {
        teamService.update(id, dto);
        return ApiResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<Void> delete(@PathVariable String id) throws Exception {
        teamService.delete(id);
        return ApiResponseDto.success();
    }
}
