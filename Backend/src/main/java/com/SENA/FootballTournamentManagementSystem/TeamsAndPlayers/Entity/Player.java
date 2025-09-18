
package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class Player extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "jersey_number", nullable = false, unique = true)
    private Integer jerseyNumber;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "team_id", nullable = false)
    private UUID teamId;
}
