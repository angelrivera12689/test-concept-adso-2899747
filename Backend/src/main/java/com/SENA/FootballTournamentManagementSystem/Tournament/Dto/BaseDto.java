package com.SENA.FootballTournamentManagementSystem.Tournament.Dto;

import lombok.Data;
import java.util.UUID;

@Data
public abstract class BaseDto {
    private UUID id;
    private String status;
}
