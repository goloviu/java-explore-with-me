package ru.yandex.practicum.model;

import ru.yandex.practicum.dto.HitDto;

public class HitMapper {

    public static Hit toHit(HitDto hitDto) {
        if (hitDto != null) {
            return Hit.builder()
                    .app(hitDto.getApp())
                    .uri(hitDto.getUri())
                    .ip(hitDto.getIp())
                    .timestamp(hitDto.getTimestamp())
                    .build();
        }
        return null;
    }
}
