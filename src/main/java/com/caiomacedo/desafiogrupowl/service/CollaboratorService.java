package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorAlreadyExistsException;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorNotFoundException;
import com.caiomacedo.desafiogrupowl.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;
    private final CollaboratorItemService collaboratorItemService;

    public CollaboratorService(CollaboratorRepository collaboratorRepository, CollaboratorItemService collaboratorItemService) {
        this.collaboratorRepository = collaboratorRepository;
        this.collaboratorItemService = collaboratorItemService;
    }

    public void createCollaborator(Collaborator collaborator) {
        if(collaboratorRepository.findOneByCpf(collaborator.getCpf()).isPresent()){
            throw new CollaboratorAlreadyExistsException();
        }
        collaboratorRepository.createCollaborator(collaborator.getName(), collaborator.getCpf());

        var c = findCollaboratorByCpf(collaborator.getCpf());
        collaboratorItemService.registerAllItems(c.getId(), collaborator.getItems());
    }

    public Collaborator findCollaboratorById(Long id) {
        return collaboratorRepository.findOneById(id).orElseThrow(CollaboratorNotFoundException::new);
    }

    public Collaborator findCollaboratorByCpf(String cpf) {
        return collaboratorRepository.findOneByCpf(cpf).orElseThrow(CollaboratorNotFoundException::new);
    }

    public void updateCollaboratorById(Long id, Collaborator collaborator) {
        if(findCollaboratorById(id) != null){
            collaboratorRepository.updateOneById(id, collaborator.getName(), collaborator.getCpf());
        }
    }

    public void deleteCollaboratorById(Long id) {
        if(findCollaboratorById(id) != null) {
            collaboratorRepository.deleteOneById(id);
        }
    }
}
