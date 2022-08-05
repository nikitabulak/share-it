package ru.practicum.shareit.user;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.EmailAlreadyExistException;
import ru.practicum.shareit.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> repository = new HashMap<>();
    private final Set<String> emails = new HashSet<>();

    @Override
    public List<UserDto> getAllUsers() {
        return repository.values().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(long userId) {
        if (repository.containsKey(userId)) {
            return UserMapper.toUserDto(repository.get(userId));
        } else {
            throw new UserNotFoundException("Пользователь с таким id не найден!");
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (!emails.contains(userDto.getEmail())) {
            User user = UserMapper.toUser(userDto);
            repository.put(user.getId(), user);
            emails.add(user.getEmail());
            return UserMapper.toUserDto(user);
        } else {
            throw new EmailAlreadyExistException("Пользователь с таким email уже существует!");
        }
    }

    @Override
    public UserDto updateUser(long userId, UserDto userDto) {
        if (repository.containsKey(userId)) {
            User updatingUser = repository.get(userId);
            if (userDto.getName() != null) {
                updatingUser.setName(userDto.getName());
            }
            if (userDto.getEmail() != null) {
                if (!emails.contains(userDto.getEmail())) {
                    emails.remove(updatingUser.getEmail());
                    emails.add(userDto.getEmail());
                    updatingUser.setEmail(userDto.getEmail());
                } else {
                    throw new EmailAlreadyExistException("Пользователь с таким email уже существует!");
                }
            }
            repository.put(userId, updatingUser);
            return UserMapper.toUserDto(updatingUser);
        } else {
            throw new UserNotFoundException("Пользователь с таким id не найден!");
        }
    }

    @Override
    public void deleteUser(long userId) {
        emails.remove(repository.get(userId).getEmail());
        repository.remove(userId);
    }
}
