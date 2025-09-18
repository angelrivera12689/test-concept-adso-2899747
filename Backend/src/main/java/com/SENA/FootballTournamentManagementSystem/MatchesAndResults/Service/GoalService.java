package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Service;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.GoalRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.GoalResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Goal;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository.IGoalRepository;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class GoalService implements IGoalService {
    private final IGoalRepository goalRepository;

    @Override
    public List<GoalResponseDto> all() {
        List<Goal> goals = goalRepository.findAll();
        List<GoalResponseDto> dtos = new ArrayList<>();
        for (Goal goal : goals) {
            dtos.add(GoalResponseDto.builder()
                    .id(goal.getId())
                    .matchId(goal.getMatchId())
                    .playerId(goal.getPlayerId())
                    .minute(goal.getMinute())
                    .goalType(goal.getGoalType())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<GoalResponseDto> findById(String id) {
        return goalRepository.findById(UUID.fromString(id))
                .map(goal -> GoalResponseDto.builder()
                        .id(goal.getId())
                        .matchId(goal.getMatchId())
                        .playerId(goal.getPlayerId())
                        .minute(goal.getMinute())
                        .goalType(goal.getGoalType())
                        .build());
    }

    @Override
    public GoalResponseDto save(GoalRequestDto dto) {
        Goal goal = Goal.builder()
                .matchId(dto.getMatchId())
                .playerId(dto.getPlayerId())
                .minute(dto.getMinute())
                .goalType(dto.getGoalType())
                .build();
        Goal saved = goalRepository.save(goal);
        return GoalResponseDto.builder()
                .id(saved.getId())
                .matchId(saved.getMatchId())
                .playerId(saved.getPlayerId())
                .minute(saved.getMinute())
                .goalType(saved.getGoalType())
                .build();
    }

    @Override
    public void update(String id, GoalRequestDto dto) {
        Goal goal = goalRepository.findById(UUID.fromString(id)).orElseThrow();
        goal.setMatchId(dto.getMatchId());
        goal.setPlayerId(dto.getPlayerId());
        goal.setMinute(dto.getMinute());
        goal.setGoalType(dto.getGoalType());
        goalRepository.save(goal);
    }

    @Override
    public void delete(String id) {
        goalRepository.deleteById(UUID.fromString(id));
    }
}
