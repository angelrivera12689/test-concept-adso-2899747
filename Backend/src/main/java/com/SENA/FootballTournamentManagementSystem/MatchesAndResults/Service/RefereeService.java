package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Service;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.RefereeRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.RefereeResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Referee;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository.IRefereeRepository;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IRefereeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RefereeService implements IRefereeService {
    private final IRefereeRepository refereeRepository;

    @Override
    public List<RefereeResponseDto> all() {
        List<Referee> referees = refereeRepository.findAll();
        List<RefereeResponseDto> dtos = new ArrayList<>();
        for (Referee referee : referees) {
            dtos.add(RefereeResponseDto.builder()
                    .id(referee.getId())
                    .name(referee.getName())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<RefereeResponseDto> findById(String id) {
        return refereeRepository.findById(UUID.fromString(id))
                .map(referee -> RefereeResponseDto.builder()
                        .id(referee.getId())
                        .name(referee.getName())
                        .build());
    }

    @Override
    public RefereeResponseDto save(RefereeRequestDto dto) {
        Referee referee = Referee.builder()
                .name(dto.getName())
                .build();
        Referee saved = refereeRepository.save(referee);
        return RefereeResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .build();
    }

    @Override
    public void update(String id, RefereeRequestDto dto) {
        Referee referee = refereeRepository.findById(UUID.fromString(id)).orElseThrow();
        referee.setName(dto.getName());
        refereeRepository.save(referee);
    }

    @Override
    public void delete(String id) {
        refereeRepository.deleteById(UUID.fromString(id));
    }
}
