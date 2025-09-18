package com.SENA.FootballTournamentManagementSystem.TeamsAndPlayers.Dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {
    private String message;
    private T data;
    private String status;

    public static <T> ApiResponseDto<T> success(T data) {
        return ApiResponseDto.<T>builder()
                .status("success")
                .data(data)
                .message(null)
                .build();
    }

    public static <T> ApiResponseDto<T> success() {
        return ApiResponseDto.<T>builder()
                .status("success")
                .data(null)
                .message(null)
                .build();
    }

    public static <T> ApiResponseDto<T> notFound(String message) {
        return ApiResponseDto.<T>builder()
                .status("not_found")
                .data(null)
                .message(message)
                .build();
    }
}
