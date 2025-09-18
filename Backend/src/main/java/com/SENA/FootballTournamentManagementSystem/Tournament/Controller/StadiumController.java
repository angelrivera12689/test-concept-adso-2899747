package com.SENA.FootballTournamentManagementSystem.Tournament.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Response.StadiumResponseDto;
import com.SENA.FootballTournamentManagementSystem.Tournament.IService.IStadiumService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/stadium")
public class StadiumController extends BaseController<StadiumResponseDto, IStadiumService> {
    public StadiumController(IStadiumService service) {
        super(service, "Stadium");
    }
}
