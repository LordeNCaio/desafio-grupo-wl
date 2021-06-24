package com.caiomacedo.desafiogrupowl.controller;

import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody Item item){
        itemService.createItem(item);
    }

    @GetMapping("/id/{id}")
    public Item findItemById(@PathVariable Long id){
        return itemService.findItemById(id);
    }

    @GetMapping("/all")
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @PutMapping("/id/{id}")
    public void updateItemById(@PathVariable Long id, @ModelAttribute Item item){
        itemService.updateItemById(id, item);
    }

    @DeleteMapping("/id/{id}")
    public void removeItem(@PathVariable Long id){
        itemService.deleteItemById(id);
    }

}
