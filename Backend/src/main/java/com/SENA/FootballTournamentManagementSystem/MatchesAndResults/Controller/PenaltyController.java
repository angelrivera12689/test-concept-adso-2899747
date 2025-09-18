package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Controller;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.PenaltyResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.PenaltyRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IPenaltyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyController extends BaseController<PenaltyResponseDto, PenaltyRequestDto, IPenaltyService> {
    public PenaltyController(IPenaltyService service) {
        super(service, "Penalty");
    }
}
