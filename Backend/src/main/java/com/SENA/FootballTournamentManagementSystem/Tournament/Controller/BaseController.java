package com.SENA.FootballTournamentManagementSystem.Tournament.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SENA.FootballTournamentManagementSystem.Tournament.Dto.ApiResponseDto;
import com.SENA.FootballTournamentManagementSystem.Tournament.IService.IBaseService;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<T, S extends IBaseService<?, T>> {
    protected S service;
    protected String entityName;

    protected BaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<T>>> findAll() {
        try {
            return ResponseEntity.ok(new ApiResponseDto<>("Datos obtenidos", service.all(), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Optional<T>>> show(@PathVariable String id) {
        try {
            Optional<T> entity = service.findById(id);
            return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", entity, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<T>> save(@RequestBody T dto) {
        try {
            T saved = service.save(dto);
            return ResponseEntity.ok(new ApiResponseDto<>("Datos guardados", saved, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<T>> update(@PathVariable String id, @RequestBody T dto) {
        try {
            service.update(id, dto);
            return ResponseEntity.ok(new ApiResponseDto<>("Datos actualizados", null, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<T>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<>("Registro eliminado", null, "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, "error"));
        }
    }
}
