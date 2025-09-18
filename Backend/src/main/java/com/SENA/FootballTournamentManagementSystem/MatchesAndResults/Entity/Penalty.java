package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "penalty")
public class Penalty extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "match_id", nullable = false)
    private UUID matchId;

    @Column(name = "player_id", nullable = false)
    private UUID playerId;

    @Column(name = "penalty_type", nullable = false)
    private String penaltyType;

    @Column(name = "minute", nullable = false)
    private Integer minute;

    @Column(name = "reason", nullable = false)
    private String reason;
}
