package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.entity.dto.CollaboratorItems;
import com.caiomacedo.desafiogrupowl.exception.item.ItemAlreadyInUseException;
import com.caiomacedo.desafiogrupowl.exception.item.ItemNotFoundException;
import com.caiomacedo.desafiogrupowl.repository.CollaboratorRepository;
import com.caiomacedo.desafiogrupowl.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollaboratorItemService {

    private final CollaboratorRepository collaboratorRepository;
    private final ItemRepository itemRepository;

    public CollaboratorItemService(CollaboratorRepository collaboratorRepository, ItemRepository itemRepository) {
        this.collaboratorRepository = collaboratorRepository;
        this.itemRepository = itemRepository;
    }

    public List<Item> findCollaboratorItems(Long id) {
        return itemRepository.findCollaboratorItems(id);
    }

    public List<CollaboratorItems> findCollaboratorAndItems() {
        List<CollaboratorItems> collaboratorItems = new ArrayList<>();
        collaboratorRepository.findCollaboratorAndItems().forEach(ci -> {
            var data = ci.split(",");
            var items = data[2].split("\\|");
            collaboratorItems.add(new CollaboratorItems(data[0], data[1], items));
        });
        return collaboratorItems;
    }

    public void addAllItems(Long id, List<Long> items) {
        for (Long x : items) {
            var item = itemRepository.findOneById(x).orElseThrow(ItemNotFoundException::new);
            if (itemRepository.findOneUsed(id, item.getId()).isPresent()) {
                throw new ItemAlreadyInUseException();
            }
            collaboratorRepository.addCollaboratorItem(id, item.getId());
        }
    }

    public void removeAllItems(Long id, List<Long> items) {
        for (Long itemId : items) {
            collaboratorRepository.removeCollaboratorItem(id, itemId);
        }
    }
}
