package com.caiomacedo.desafiogrupowl.controller;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.service.CollaboratorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id/{id}")
    public Collaborator findCollaborator(@PathVariable Long id){
        return collaboratorService.findCollaboratorById(id);
    }

    @PutMapping("/id/{id}")
    public void updateCollaboratorById(@PathVariable Long id, @RequestBody Collaborator collaborator){
        collaboratorService.updateCollaboratorById(id, collaborator);
    }

    @DeleteMapping("/id/{id}")
    public void removeCollaborator(@PathVariable Long id){
        collaboratorService.deleteCollaboratorById(id);
    }

}
