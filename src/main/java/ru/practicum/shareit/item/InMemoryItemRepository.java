package ru.practicum.shareit.item;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.ItemNotFoundException;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryItemRepository {}
//implements ItemRepository {
//    private final Map<Long, Item> repository = new HashMap<>();
//
//    @Override
//    public ItemDto createItem(User user, ItemDto itemDto) {
//        Item item = ItemMapper.toItem(user, itemDto);
//        repository.put(item.getId(), item);
//        return ItemMapper.toItemDto(item);
//    }
//
//    @Override
//    public ItemDto updateItem(long userId, long itemId, ItemDto itemDto) {
//        if (repository.get(itemId).getOwner().getId() != userId) {
//            throw new ItemNotFoundException(
//                    String.format("Пользователь с id=%d не владеет вещью с id=%d", userId, itemId));
//        }
//        if (repository.containsKey(itemId)) {
//            Item updatingItem = repository.get(itemId);
//            if (itemDto.getName() != null) {
//                updatingItem.setName(itemDto.getName());
//            }
//            if (itemDto.getDescription() != null) {
//                updatingItem.setDescription(itemDto.getDescription());
//            }
//            if (itemDto.getAvailable() != null) {
//                updatingItem.setAvailable(itemDto.getAvailable());
//            }
//            repository.put(itemId, updatingItem);
//            return ItemMapper.toItemDto(updatingItem);
//        } else {
//            throw new ItemNotFoundException("Вещь с таким id не найдена!");
//        }
//    }
//
//    @Override
//    public ItemDto getItem(long itemId) {
//        if (repository.containsKey(itemId)) {
//            return ItemMapper.toItemDto(repository.get(itemId));
//        } else {
//            throw new ItemNotFoundException("Вещь с таким id не найдена!");
//        }
//    }
//
//    @Override
//    public List<ItemDto> getAllItems(long userId) {
//        return repository.values().stream()
//                .filter(x -> x.getOwner().getId() == userId)
//                .map(ItemMapper::toItemDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ItemDto> search(String text) {
//        if (!text.isBlank()) {
//            return repository.values().stream()
//                    .filter(x -> (x.getName().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))
//                            || x.getDescription().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT)))
//                            && x.isAvailable())
//                    .map(ItemMapper::toItemDto)
//                    .collect(Collectors.toList());
//        } else {
//            return new ArrayList<>();
//        }
//    }
//}
