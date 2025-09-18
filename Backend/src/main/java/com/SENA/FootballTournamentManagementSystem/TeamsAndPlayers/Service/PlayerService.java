package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Service;

import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Request.PlayerRequestDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto.Response.PlayerResponseDto;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.Player;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IRepository.IPlayerRepository;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerService {
    private final IPlayerRepository playerRepository;

    @Override
    public List<PlayerResponseDto> all() {
        List<Player> players = playerRepository.findAll();
        List<PlayerResponseDto> dtos = new ArrayList<>();
        for (Player player : players) {
            dtos.add(PlayerResponseDto.builder()
                    .id(player.getId())
                    .name(player.getName())
                    .jerseyNumber(player.getJerseyNumber())
                    .position(player.getPosition())
                    .teamId(player.getTeamId())
                    .build());
        }
        return dtos;
    }

    @Override
    public Optional<PlayerResponseDto> findById(String id) {
        return playerRepository.findById(UUID.fromString(id))
                .map(player -> PlayerResponseDto.builder()
                        .id(player.getId())
                        .name(player.getName())
                        .jerseyNumber(player.getJerseyNumber())
                        .position(player.getPosition())
                        .teamId(player.getTeamId())
                        .build());
    }

    @Override
    public PlayerResponseDto save(PlayerRequestDto dto) {
        Player player = Player.builder()
                .name(dto.getName())
                .jerseyNumber(dto.getJerseyNumber())
                .position(dto.getPosition())
                .teamId(dto.getTeamId())
                .build();
        Player saved = playerRepository.save(player);
        return PlayerResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .jerseyNumber(saved.getJerseyNumber())
                .position(saved.getPosition())
                .teamId(saved.getTeamId())
                .build();
    }

    @Override
    public void update(String id, PlayerRequestDto dto) {
        Player player = playerRepository.findById(UUID.fromString(id)).orElseThrow();
        player.setName(dto.getName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setPosition(dto.getPosition());
        player.setTeamId(dto.getTeamId());
        playerRepository.save(player);
    }

    @Override
    public void delete(String id) {
        playerRepository.deleteById(UUID.fromString(id));
    }
}
