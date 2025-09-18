package com.SENA.FootballTournamentManagementSystem.Tournament.Service;

import com.SENA.FootballTournamentManagementSystem.Tournament.Entity.Stadium;
import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.Response.StadiumResponseDto;
import com.SENA.FootballTournamentManagementSystem.Tournament.IRepository.IStadiumRepository;
import com.SENA.FootballTournamentManagementSystem.Tournament.IService.IStadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StadiumService implements IStadiumService {
    @Autowired
    private IStadiumRepository stadiumRepository;

    private StadiumResponseDto toDto(Stadium entity) {
        if (entity == null) return null;
    return StadiumResponseDto.builder()
        .name(entity.getName())
        .location(entity.getLocation())
        .capacity(entity.getCapacity())
        .build();
    }

    private Stadium toEntity(StadiumResponseDto dto) {
        if (dto == null) return null;
    return Stadium.builder()
        .name(dto.getName())
        .location(dto.getLocation())
        .capacity(dto.getCapacity())
        .build();
    }

    @Override
    public List<StadiumResponseDto> all() {
        return stadiumRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StadiumResponseDto> findById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return stadiumRepository.findById(uuid).map(this::toDto);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public StadiumResponseDto save(StadiumResponseDto dto) {
        Stadium entity = toEntity(dto);
        Stadium saved = stadiumRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public void update(String id, StadiumResponseDto dto) {
        UUID uuid = UUID.fromString(id);
        Stadium entity = toEntity(dto);
        entity.setId(uuid);
        stadiumRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        stadiumRepository.deleteById(uuid);
    }
}
