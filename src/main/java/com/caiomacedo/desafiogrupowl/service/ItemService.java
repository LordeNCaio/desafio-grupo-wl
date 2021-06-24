package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Item item) {
        itemRepository.createItem(item.getName());
    }

    public Item findItemById(Long id) {
        return itemRepository.findOneById(id).orElse(null);
    }

    public void updateItemById(Long id, Item item) {
        itemRepository.updateOneById(id, item.getName());
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteOneById(id);
    }
}
