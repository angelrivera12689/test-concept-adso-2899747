package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Controller;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.RefereeResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.RefereeRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IRefereeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/referees")
public class RefereeController extends BaseController<RefereeResponseDto, RefereeRequestDto, IRefereeService> {
    public RefereeController(IRefereeService service) {
        super(service, "Referee");
    }
}
