package com.SENA.FootballTournamentManagementSystem.Tournament.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Response.TournamentResponseDto;
import com.SENA.FootballTournamentManagementSystem.Tournament.IService.ITournamentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/tournament")
public class TournamentController extends BaseController<TournamentResponseDto, ITournamentService> {
    public TournamentController(ITournamentService service) {
        super(service, "Tournament");
    }
}
