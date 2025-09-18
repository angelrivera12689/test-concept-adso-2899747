package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Service;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.PenaltyRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.PenaltyResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Penalty;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository.IPenaltyRepository;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IPenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PenaltyService implements IPenaltyService {
    private final IPenaltyRepository penaltyRepository;

    @Override
    public List<PenaltyResponseDto> all() {
        List<Penalty> penalties = penaltyRepository.findAll();
        List<PenaltyResponseDto> dtos = new ArrayList<>();
        for (Penalty penalty : penalties) {
            dtos.add(PenaltyResponseDto.builder()
                    .id(penalty.getId())
                    .matchId(penalty.getMatchId())
                    .playerId(penalty.getPlayerId())
                    .penaltyType(penalty.getPenaltyType())
                    .minute(penalty.getMinute())
                    .reason(penalty.getReason())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<PenaltyResponseDto> findById(String id) {
        return penaltyRepository.findById(UUID.fromString(id))
                .map(penalty -> PenaltyResponseDto.builder()
                        .id(penalty.getId())
                        .matchId(penalty.getMatchId())
                        .playerId(penalty.getPlayerId())
                        .penaltyType(penalty.getPenaltyType())
                        .minute(penalty.getMinute())
                        .reason(penalty.getReason())
                        .build());
    }

    @Override
    public PenaltyResponseDto save(PenaltyRequestDto dto) {
        Penalty penalty = Penalty.builder()
                .matchId(dto.getMatchId())
                .playerId(dto.getPlayerId())
                .penaltyType(dto.getPenaltyType())
                .minute(dto.getMinute())
                .reason(dto.getReason())
                .build();
        Penalty saved = penaltyRepository.save(penalty);
        return PenaltyResponseDto.builder()
                .id(saved.getId())
                .matchId(saved.getMatchId())
                .playerId(saved.getPlayerId())
                .penaltyType(saved.getPenaltyType())
                .minute(saved.getMinute())
                .reason(saved.getReason())
                .build();
    }

    @Override
    public void update(String id, PenaltyRequestDto dto) {
        Penalty penalty = penaltyRepository.findById(UUID.fromString(id)).orElseThrow();
        penalty.setMatchId(dto.getMatchId());
        penalty.setPlayerId(dto.getPlayerId());
        penalty.setPenaltyType(dto.getPenaltyType());
        penalty.setMinute(dto.getMinute());
        penalty.setReason(dto.getReason());
        penaltyRepository.save(penalty);
    }

    @Override
    public void delete(String id) {
        penaltyRepository.deleteById(UUID.fromString(id));
    }
}
