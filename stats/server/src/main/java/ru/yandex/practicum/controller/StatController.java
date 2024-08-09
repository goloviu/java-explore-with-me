package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.HitDto;
import ru.yandex.practicum.dto.StatsDto;
import ru.yandex.practicum.service.StatService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
public class StatController {
    private final StatService statService;
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveUserRequestInfo(@RequestBody HitDto hitDto) {
        log.info("Получен POST запрос на сохранение информации запроса пользователя. Входящие данные: \n {}", hitDto);
        statService.saveHit(hitDto);
    }

    @GetMapping("/stats")
    public List<StatsDto> getStats(@RequestParam @DateTimeFormat(pattern = DATE_FORMAT) LocalDateTime start,
                                   @RequestParam @DateTimeFormat(pattern = DATE_FORMAT) LocalDateTime end,
                                   @RequestParam(required = false, name = "uris") List<String> uris,
                                   @RequestParam(required = false, defaultValue = "false", name = "unique") Boolean unique) {
        log.info("Получен GET запрос на получение статистика от даты: {}, до даты: {}, список uri \n {}," +
                " уникальность посещений: {}", start, end, uris, unique);
        return statService.getStats(start, end, uris, unique);
    }
}