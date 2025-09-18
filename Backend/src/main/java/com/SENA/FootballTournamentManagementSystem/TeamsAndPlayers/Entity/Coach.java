
package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coach")
public class Coach extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}
