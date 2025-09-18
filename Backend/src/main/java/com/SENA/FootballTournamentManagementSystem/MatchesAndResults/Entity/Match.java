package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class Match extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "tournament_id", nullable = false)
    private UUID tournamentId;

    @Column(name = "home_team_id", nullable = false)
    private UUID homeTeamId;

    @Column(name = "away_team_id", nullable = false)
    private UUID awayTeamId;

    @Column(name = "stadium_id", nullable = false)
    private UUID stadiumId;

    @Column(name = "referee_id", nullable = false)
    private UUID refereeId;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;
}
