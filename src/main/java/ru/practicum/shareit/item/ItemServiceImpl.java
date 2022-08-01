package ru.practicum.shareit.item;

import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.user.UserService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userRepository;


    public ItemServiceImpl(ItemRepository itemRepository, UserService userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public ItemDto createItem(long userId, ItemDto itemDto) {
        userRepository.getUser(userId);
        return itemRepository.createItem(userId, itemDto);
    }

    public ItemDto updateItem(long userId, long itemId, ItemDto itemDto) {
        userRepository.getUser(userId);
        return itemRepository.updateItem(userId, itemId, itemDto);
    }

    public ItemDto getItem(long itemId) {
        return itemRepository.getItem(itemId);
    }

    public List<ItemDto> getAllItems(long userId) {
        userRepository.getUser(userId);
        return itemRepository.getAllItems(userId);
    }

    public List<ItemDto> search(String text) {
        return itemRepository.search(text);
    }
}
