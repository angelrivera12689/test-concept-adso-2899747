package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Controller;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.PlayerRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.PlayerResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.IPlayerService;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final IPlayerService playerService;

    @GetMapping
    public ApiResponseDto<List<PlayerResponseDto>> getAll() throws Exception {
        return ApiResponseDto.success(playerService.all());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<PlayerResponseDto> getById(@PathVariable String id) throws Exception {
        return playerService.findById(id)
                .map(ApiResponseDto::success)
                .orElse(ApiResponseDto.notFound("Player not found"));
    }

    @PostMapping
    public ApiResponseDto<PlayerResponseDto> create(@RequestBody PlayerRequestDto dto) throws Exception {
        return ApiResponseDto.success(playerService.save(dto));
    }

    @PutMapping("/{id}")
    public ApiResponseDto<Void> update(@PathVariable String id, @RequestBody PlayerRequestDto dto) throws Exception {
        playerService.update(id, dto);
        return ApiResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<Void> delete(@PathVariable String id) throws Exception {
        playerService.delete(id);
        return ApiResponseDto.success();
    }
}
