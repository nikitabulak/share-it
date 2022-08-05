package ru.practicum.shareit.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.practicum.shareit.validation.UserUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@AllArgsConstructor
@Data
public class UserDto {
    private long id;
    @NotNull
    private String name;
    @Email(groups = {UserUpdate.class, Default.class})
    @NotNull
    private String email;
}
