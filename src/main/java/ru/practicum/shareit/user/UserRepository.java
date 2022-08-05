package ru.practicum.shareit.user;

import java.util.List;

public interface UserRepository {
    List<UserDto> getAllUsers();

    UserDto getUser(long userId);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(long userId, UserDto userDto);

    void deleteUser(long userId);
}
