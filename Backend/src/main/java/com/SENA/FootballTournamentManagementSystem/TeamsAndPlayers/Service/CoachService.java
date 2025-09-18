package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Service;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.CoachRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.CoachResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Coach;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository.ICoachRepository;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.ICoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CoachService implements ICoachService {
    private final ICoachRepository coachRepository;

    @Override
    public List<CoachResponseDto> all() {
        List<Coach> coaches = coachRepository.findAll();
        List<CoachResponseDto> dtos = new ArrayList<>();
        for (Coach coach : coaches) {
            dtos.add(CoachResponseDto.builder()
                    .id(coach.getId())
                    .name(coach.getName())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<CoachResponseDto> findById(String id) {
        return coachRepository.findById(UUID.fromString(id))
                .map(coach -> CoachResponseDto.builder()
                        .id(coach.getId())
                        .name(coach.getName())
                        .build());
    }

    @Override
    public CoachResponseDto save(CoachRequestDto dto) {
        Coach coach = Coach.builder()
                .name(dto.getName())
                .build();
        Coach saved = coachRepository.save(coach);
        return CoachResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .build();
    }

    @Override
    public void update(String id, CoachRequestDto dto) {
        Coach coach = coachRepository.findById(UUID.fromString(id)).orElseThrow();
        coach.setName(dto.getName());
        coachRepository.save(coach);
    }

    @Override
    public void delete(String id) {
        coachRepository.deleteById(UUID.fromString(id));
    }
}
