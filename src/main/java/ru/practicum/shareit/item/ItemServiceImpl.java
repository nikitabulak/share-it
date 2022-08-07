package ru.practicum.shareit.item;

import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.ItemNotFoundException;
import ru.practicum.shareit.exception.UserNotFoundException;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.UserMapper;
import ru.practicum.shareit.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userRepository;


    public ItemServiceImpl(ItemRepository itemRepository, UserService userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public ItemDto getItem(long itemId) {
        return ItemMapper.toItemDto(itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Вещь с таким id не найдена!")));
    }

    public ItemDto createItem(long userId, ItemDto itemDto) {
        Item item = itemRepository.save(ItemMapper.toItem(UserMapper.toUser(userRepository.getUser(userId)), itemDto));
        return ItemMapper.toItemDto(item);
    }

    public ItemDto updateItem(long userId, long itemId, ItemDto itemDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Вещь с таким id не найдена!"));
        System.out.println(item);
        if (item.getOwner().getId() != userId) {
            throw new UserNotFoundException(
                    String.format("Пользователь с id=%d не владеет вещью с id=%d", userId, itemId));
        }
        if (itemDto.getName() != null) {
            item.setName(itemDto.getName());
        }
        if (itemDto.getDescription() != null) {
            item.setDescription(itemDto.getDescription());
        }
        if (itemDto.getAvailable() != null) {
            item.setAvailable(itemDto.getAvailable());
        }
        return ItemMapper.toItemDto(itemRepository.save(item));
    }

    public List<ItemDto> getAllItems(long userId) {
        userRepository.getUser(userId);
        return itemRepository.findAll().stream()
                .filter(x -> x.getOwner().getId() == userId)
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }

    public List<ItemDto> search(String text) {
        if (!text.isBlank()) {
            return itemRepository.search(text).stream()
                    .map(ItemMapper::toItemDto)
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
