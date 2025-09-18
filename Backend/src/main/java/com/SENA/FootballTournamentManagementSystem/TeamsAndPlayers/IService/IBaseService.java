package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.IService;

import java.util.List;
import java.util.Optional;
import com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Entity.BaseEntity;

public interface IBaseService<T extends BaseEntity, R, Q> {
    List<R> all() throws Exception;
    Optional<R> findById(String id) throws Exception;
    R save(Q dto) throws Exception;
    void update(String id, Q dto) throws Exception;
    void delete(String id) throws Exception;
}
