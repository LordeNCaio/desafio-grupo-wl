package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.exception.item.ItemAlreadyInUseException;
import com.caiomacedo.desafiogrupowl.exception.item.ItemNotFoundException;
import com.caiomacedo.desafiogrupowl.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorItemService {

    private final ItemRepository itemRepository;

    public CollaboratorItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void registerAllItems(Long id, List<Item> items) {
        items.forEach(x -> {
            var item = itemRepository.findOneById(x.getId()).orElseThrow(ItemNotFoundException::new);
//            if(itemRepository.findItemInUse(item.getId()).isPresent()){
//                throw new ItemAlreadyInUseException();
//            }
            itemRepository.registerCollaboratorItem(id, item.getId());
        });
    }
}
