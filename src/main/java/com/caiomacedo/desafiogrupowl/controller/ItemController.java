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
    public void createItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Item findItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @PutMapping(value = "/id/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateItemById(@PathVariable Long id, @RequestBody Item item) {
        itemService.updateItemById(id, item);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
}
