package com.SENA.FootballTournamentManagementSystem.Tournament.IService;

import java.util.List;
import java.util.Optional;
import com.SENA.FootballTournamentManagementSystem.Tournament.Entity.BaseEntity;

public interface IBaseService<T extends BaseEntity, D> {
    List<D> all() throws Exception;
    Optional<D> findById(String id) throws Exception;
    D save(D dto) throws Exception;
    void update(String id, D dto) throws Exception;
    void delete(String id) throws Exception;
}
