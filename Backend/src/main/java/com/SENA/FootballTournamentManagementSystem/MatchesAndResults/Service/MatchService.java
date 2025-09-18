package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Service;

import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Request.MatchRequestDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.Response.MatchResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity.Match;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IRepository.IMatchRepository;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MatchService implements IMatchService {
    private final IMatchRepository matchRepository;

    @Override
    public List<MatchResponseDto> all() {
        List<Match> matches = matchRepository.findAll();
        List<MatchResponseDto> dtos = new ArrayList<>();
        for (Match match : matches) {
            dtos.add(MatchResponseDto.builder()
                    .id(match.getId())
                    .tournamentId(match.getTournamentId())
                    .homeTeamId(match.getHomeTeamId())
                    .awayTeamId(match.getAwayTeamId())
                    .stadiumId(match.getStadiumId())
                    .refereeId(match.getRefereeId())
                    .date(match.getDate())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<MatchResponseDto> findById(String id) {
        return matchRepository.findById(UUID.fromString(id))
                .map(match -> MatchResponseDto.builder()
                        .id(match.getId())
                        .tournamentId(match.getTournamentId())
                        .homeTeamId(match.getHomeTeamId())
                        .awayTeamId(match.getAwayTeamId())
                        .stadiumId(match.getStadiumId())
                        .refereeId(match.getRefereeId())
                        .date(match.getDate())
                        .build());
    }

    @Override
    public MatchResponseDto save(MatchRequestDto dto) {
        Match match = Match.builder()
                .tournamentId(dto.getTournamentId())
                .homeTeamId(dto.getHomeTeamId())
                .awayTeamId(dto.getAwayTeamId())
                .stadiumId(dto.getStadiumId())
                .refereeId(dto.getRefereeId())
                .date(dto.getDate())
                .build();
        Match saved = matchRepository.save(match);
        return MatchResponseDto.builder()
                .id(saved.getId())
                .tournamentId(saved.getTournamentId())
                .homeTeamId(saved.getHomeTeamId())
                .awayTeamId(saved.getAwayTeamId())
                .stadiumId(saved.getStadiumId())
                .refereeId(saved.getRefereeId())
                .date(saved.getDate())
                .build();
    }

    @Override
    public void update(String id, MatchRequestDto dto) {
        Match match = matchRepository.findById(UUID.fromString(id)).orElseThrow();
        match.setTournamentId(dto.getTournamentId());
        match.setHomeTeamId(dto.getHomeTeamId());
        match.setAwayTeamId(dto.getAwayTeamId());
        match.setStadiumId(dto.getStadiumId());
        match.setRefereeId(dto.getRefereeId());
        match.setDate(dto.getDate());
        matchRepository.save(match);
    }

    @Override
    public void delete(String id) {
        matchRepository.deleteById(UUID.fromString(id));
    }
}
