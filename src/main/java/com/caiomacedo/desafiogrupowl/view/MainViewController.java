package com.caiomacedo.desafiogrupowl.view;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.service.CollaboratorService;
import com.caiomacedo.desafiogrupowl.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainViewController {

    private final CollaboratorService collaboratorService;
    private final ItemService itemService;

    public MainViewController(CollaboratorService collaboratorService, ItemService itemService) {
        this.collaboratorService = collaboratorService;
        this.itemService = itemService;
    }

    @GetMapping
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/items")
    public ModelAndView itemsPage(){
        ModelAndView modelAndView = new ModelAndView();
        var items = itemService.findAll();
        modelAndView.setViewName("item/items");
        modelAndView.addObject("itemsList", items);
        return modelAndView;
    }

    @GetMapping("/items/create")
    public ModelAndView itemCreate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item/create");
        modelAndView.addObject("item", new Item());
        return modelAndView;
    }

    @GetMapping("/items/edit/id/{id}")
    public ModelAndView itemCreate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item/edit");
        modelAndView.addObject("item", itemService.findItemById(id));
        return modelAndView;
    }

    @GetMapping("/collaborators")
    public ModelAndView collaboratorsPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("collaborator/collaborators");
        modelAndView.addObject("collaboratorsList", collaboratorService.findAll());
        return modelAndView;
    }

    @GetMapping("/collaborators/create")
    public ModelAndView collaboratorCreate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("collaborator/create");
        modelAndView.addObject("collaborator", new Collaborator());
        return modelAndView;
    }

    @GetMapping("/collaborators/edit/id/{id}")
    public ModelAndView collaboratorCreate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("collaborator/edit");
        modelAndView.addObject("collaborator", collaboratorService.findCollaboratorById(id));
        return modelAndView;
    }
}
