package ru.practicum.shareit.item;

import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.ItemWithBookingDto;

import java.util.List;

public interface ItemService {
    ItemDto createItem(long userId, ItemDto itemDto);

    ItemDto updateItem(long userId, long itemId, ItemDto itemDto);

    ItemWithBookingDto getItem(long userId, long itemId);

    List<ItemWithBookingDto> getAllItems(long userId);

    List<ItemDto> search(String text);
}
