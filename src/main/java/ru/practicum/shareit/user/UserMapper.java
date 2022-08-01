package ru.practicum.shareit.user;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static User toUser(UserDto userDto) {
        return new User(
                User.generateId(),
                userDto.getName(),
                userDto.getEmail()
        );
    }

    public static User toUser(long userId, UserDto userDto) {
        return new User(
                userId,
                userDto.getName(),
                userDto.getEmail()
        );
    }
}
