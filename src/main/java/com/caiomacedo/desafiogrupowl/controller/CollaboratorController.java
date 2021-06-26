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
    public void createCollaborator(@RequestBody Collaborator collaborator){
        collaboratorService.createCollaborator(collaborator);
    }

    @PostMapping("/id/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCollaboratorItems(@PathVariable Long id, @RequestParam List<Long> items){
        collaboratorService.addCollaboratorItem(id, items);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Collaborator> findAll(){
        return collaboratorService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Collaborator findCollaboratorById(@PathVariable Long id){
        return collaboratorService.findCollaboratorById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCollaboratorById(@PathVariable Long id, @RequestBody Collaborator collaborator){
        collaboratorService.updateCollaboratorById(id, collaborator);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCollaborator(@PathVariable Long id){
        collaboratorService.deleteCollaboratorById(id);
    }

}
