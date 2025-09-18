package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Controller;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.MatchResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.MatchRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IMatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matches")
public class MatchController extends BaseController<MatchResponseDto, MatchRequestDto, IMatchService> {
    public MatchController(IMatchService service) {
        super(service, "Match");
    }
}
