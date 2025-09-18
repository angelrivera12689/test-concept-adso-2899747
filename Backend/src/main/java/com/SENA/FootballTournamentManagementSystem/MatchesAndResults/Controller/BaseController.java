package com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.Dto.ApiResponseDto;
import com.SENA.FootballTournamentManagementSystem.MatchesAndResults.IService.IBaseService;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<R, Q, S extends IBaseService<?, R, Q>> {
    protected S service;
    protected String entityName;

    protected BaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<R>>> findAll() {
        try {
            return ResponseEntity.ok(new ApiResponseDto<>("Datos obtenidos", service.all(), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<R>> show(@PathVariable String id) {
        try {
            Optional<R> entity = service.findById(id);
            if (entity.isPresent()) {
                return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", entity.get(), "success"));
            } else {
                return ResponseEntity.status(404).body(new ApiResponseDto<>("No encontrado", null, "not_found"));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<R>> save(@RequestBody Q dto) {
        try {
            R saved = service.save(dto);
            return ResponseEntity.ok(new ApiResponseDto<>("Datos guardados", saved, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> update(@PathVariable String id, @RequestBody Q dto) {
        try {
            service.update(id, dto);
            return ResponseEntity.ok(new ApiResponseDto<>("Datos actualizados", null, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<>("Registro eliminado", null, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }
}
