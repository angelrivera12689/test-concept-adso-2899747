package com.SENA.FootballTournamentManagementSystem.Tournament.Service;

import com.SENA.FootballTournamentManagementSystem.Tournament.Entity.Tournament;
import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Response.TournamentResponseDto;
import com.SENA.FootballTournamentManagementSystem.Tournament.IRepository.ITournamentRepository;
import com.SENA.FootballTournamentManagementSystem.Tournament.IService.ITournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TournamentService implements ITournamentService {
    @Autowired
    private ITournamentRepository tournamentRepository;

    private TournamentResponseDto toDto(Tournament entity) {
        if (entity == null) return null;
    return TournamentResponseDto.builder()
        .code(entity.getCode())
        .name(entity.getName())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())
        .build();
    }

    private Tournament toEntity(TournamentResponseDto dto) {
        if (dto == null) return null;
    return Tournament.builder()
        .code(dto.getCode())
        .name(dto.getName())
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .build();
    }

    @Override
    public List<TournamentResponseDto> all() {
        return tournamentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TournamentResponseDto> findById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return tournamentRepository.findById(uuid).map(this::toDto);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public TournamentResponseDto save(TournamentResponseDto dto) {
        Tournament entity = toEntity(dto);
        Tournament saved = tournamentRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public void update(String id, TournamentResponseDto dto) {
        UUID uuid = UUID.fromString(id);
        Tournament entity = toEntity(dto);
        entity.setId(uuid);
        tournamentRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        tournamentRepository.deleteById(uuid);
    }
}
