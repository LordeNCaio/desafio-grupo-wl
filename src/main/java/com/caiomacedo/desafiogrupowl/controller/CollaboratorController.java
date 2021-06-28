package com.caiomacedo.desafiogrupowl.controller;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.service.CollaboratorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborators")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCollaborator(@RequestBody Collaborator collaborator) {
        collaboratorService.creatOne(collaborator);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Collaborator> findAll() {
        return collaboratorService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Collaborator findOneById(@PathVariable Long id) {
        return collaboratorService.findOneById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOneById(@PathVariable Long id, @RequestBody Collaborator collaborator) {
        collaboratorService.updateOneById(id, collaborator);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable Long id) {
        collaboratorService.deleteOneById(id);
    }

    @PostMapping(value = "/id/{id}/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCollaboratorItems(@PathVariable Long id, @RequestParam List<Long> items) {
        collaboratorService.addCollaboratorItem(id, items);
    }

    @PostMapping(value = "/id/{id}/remove", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void removeCollaboratorItems(@PathVariable Long id, @RequestParam List<Long> items) {
        collaboratorService.removeCollaboratorItem(id, items);
    }
}
