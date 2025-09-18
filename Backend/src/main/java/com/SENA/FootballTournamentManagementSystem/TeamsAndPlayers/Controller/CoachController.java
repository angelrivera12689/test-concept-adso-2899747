package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Controller;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.CoachRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.CoachResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.ICoachService;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/coaches")
@RequiredArgsConstructor
public class CoachController {
    private final ICoachService coachService;

    @GetMapping
    public ApiResponseDto<List<CoachResponseDto>> getAll() throws Exception {
        return ApiResponseDto.success(coachService.all());
    }

    @GetMapping("/{id}")
    public ApiResponseDto<CoachResponseDto> getById(@PathVariable String id) throws Exception {
        return coachService.findById(id)
                .map(ApiResponseDto::success)
                .orElse(ApiResponseDto.notFound("Coach not found"));
    }

    @PostMapping
    public ApiResponseDto<CoachResponseDto> create(@RequestBody CoachRequestDto dto) throws Exception {
        return ApiResponseDto.success(coachService.save(dto));
    }

    @PutMapping("/{id}")
    public ApiResponseDto<Void> update(@PathVariable String id, @RequestBody CoachRequestDto dto) throws Exception {
        coachService.update(id, dto);
        return ApiResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<Void> delete(@PathVariable String id) throws Exception {
        coachService.delete(id);
        return ApiResponseDto.success();
    }
}
