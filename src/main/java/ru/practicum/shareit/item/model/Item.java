package ru.practicum.shareit.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.practicum.shareit.requests.ItemRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Item {
    private static long itemId = 1;

    private long id;
    @NotNull
    private String name;
    @NotNull
    @NotBlank
    private String description;
    private boolean available;
    private long owner;//??
    private ItemRequest request;

    public static long generateId() {
        return itemId++;
    }
}
