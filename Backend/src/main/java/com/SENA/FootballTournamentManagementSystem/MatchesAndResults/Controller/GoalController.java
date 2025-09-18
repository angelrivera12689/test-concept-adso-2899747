package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Controller;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.GoalResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.GoalRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IGoalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goals")
public class GoalController extends BaseController<GoalResponseDto, GoalRequestDto, IGoalService> {
    public GoalController(IGoalService service) {
        super(service, "Goal");
    }
}
