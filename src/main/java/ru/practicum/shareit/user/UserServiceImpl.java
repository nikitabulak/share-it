package ru.practicum.shareit.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public UserDto getUser(long userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepository.createUser(userDto);
    }

    @Override
    public UserDto updateUser(long userId, UserDto userDto) {
        return userRepository.updateUser(userId, userDto);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteUser(userId);
    }
}
