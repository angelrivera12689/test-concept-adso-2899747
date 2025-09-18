
package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
public class Team extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tournament_id", nullable = false)
    private UUID tournamentId;

    @Column(name = "coach_id", nullable = false)
    private UUID coachId;
}
