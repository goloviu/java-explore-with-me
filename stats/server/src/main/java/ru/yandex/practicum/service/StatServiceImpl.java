package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.practicum.dto.HitDto;
import ru.yandex.practicum.dto.StatsDto;
import ru.yandex.practicum.exceptions.ValidationException;
import ru.yandex.practicum.model.Hit;
import ru.yandex.practicum.model.HitMapper;
import ru.yandex.practicum.repository.HitRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {
    private final HitRepository hitRepository;

    @Override
    public void saveHit(HitDto hitDto) {
        Hit hitDb = hitRepository.save(HitMapper.toHit(hitDto));
        log.info("Хит {} сохранен в БД в таблицу hits по ID: {}", hitDb, hitDb.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean isUnique) {
        if (start.isAfter(end)) {
            throw new ValidationException("Дата начала: " + start + " не может быть позже даты конца: " + end);
        }

        List<StatsDto> stats;

        if (uris != null && !uris.isEmpty()) {
            if (isUnique) {
                stats = hitRepository.findUniqueHitsByUris(start, end, uris);
            } else {
                stats = hitRepository.findHitsByUris(start, end, uris);
            }
        } else {
            if (isUnique) {
                stats = hitRepository.findUniqueHits(start, end);
            } else {
                stats = hitRepository.findHits(start, end);
            }
        }
        log.info("Получена статистика посещений: {}", stats.stream()
                .map(s -> "StatsDto{" +
                        "app='" + s.getApp() + '\'' +
                        ", uri='" + s.getUri() + '\'' +
                        ", hits='" + s.getHits() + '\'' +
                        '}')
                .collect(Collectors.toList()));
        return stats;
    }
}
