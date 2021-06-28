package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.exception.item.ItemAlreadyExistsException;
import com.caiomacedo.desafiogrupowl.exception.item.ItemNotFoundException;
import com.caiomacedo.desafiogrupowl.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Item item) {
        if (itemRepository.findOneByName(item.getName()).isPresent()) {
            throw new ItemAlreadyExistsException();
        }
        itemRepository.createOne(item.getName());
    }

    public List<Item> findAll() {
        return itemRepository.findAllItems();
    }

    public Item findOneById(Long id) {
        return itemRepository.findOneById(id).orElseThrow(ItemNotFoundException::new);
    }

    public Item findOneByName(String name) {
        return itemRepository.findOneByName(name).orElseThrow(ItemNotFoundException::new);
    }

    public void updateItemById(Long id, Item item) {
        if (findOneById(id) != null) {
            itemRepository.updateOneById(id, item.getName());
        }
    }

    public void deleteOneById(Long id) {
        if (findOneById(id) != null) {
            itemRepository.removeRelationship(id);
            itemRepository.deleteOneById(id);
        }
    }

    public List<Item> findUnusedItems() {
        return itemRepository.findUnusedItems();
    }
}
