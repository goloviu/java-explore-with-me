package ru.yandex.practicum.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompilationDto {
    @NotNull
    private Long id;

    private List<EventShortDto> events;

    @NotNull
    private boolean pinned;

    @NotNull
    private String title;
}
