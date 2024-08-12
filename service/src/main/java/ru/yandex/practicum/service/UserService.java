package ru.yandex.practicum.service;

import org.springframework.data.domain.Pageable;
import ru.yandex.practicum.enums.RatingSortType;
import ru.yandex.practicum.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    List<UserDto> getAllUsers(List<Long> ids, Pageable pageable);

    void deleteUserById(Long userId);

    List<UserDto> getAllUsersSortedByRating(RatingSortType sort, Pageable pageable);
}
