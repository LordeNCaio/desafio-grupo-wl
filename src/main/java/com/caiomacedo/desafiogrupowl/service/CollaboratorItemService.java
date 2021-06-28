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

    public void registerAllItems(Long id, List<Long> items) {
        for (Long x : items) {
            var item = itemRepository.findOneById(x).orElseThrow(ItemNotFoundException::new);
            if(itemRepository.findOneInUse(item.getId(), id).isPresent()) {
                throw new ItemAlreadyInUseException();
            }
            else if(itemRepository.findCollaboratorItem(item.getId(), id).isPresent()){
                continue;
            }
            itemRepository.registerCollaboratorItem(id, item.getId());
        }
    }
}
