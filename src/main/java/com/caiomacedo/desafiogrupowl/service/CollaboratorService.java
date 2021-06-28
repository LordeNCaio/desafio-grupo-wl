package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.entity.Item;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorAlreadyExistsException;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorNotFoundException;
import com.caiomacedo.desafiogrupowl.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;
    private final CollaboratorItemService collaboratorItemService;

    public CollaboratorService(CollaboratorRepository collaboratorRepository, CollaboratorItemService collaboratorItemService) {
        this.collaboratorRepository = collaboratorRepository;
        this.collaboratorItemService = collaboratorItemService;
    }

    public void creatOne(Collaborator collaborator) {
        if (collaboratorRepository.findOneByCpf(collaborator.getCpf()).isPresent()) {
            throw new CollaboratorAlreadyExistsException();
        }
        collaboratorRepository.createOne(collaborator.getFullName(), collaborator.getCpf());
    }

    public List<Collaborator> findAll() {
        return collaboratorRepository.findAllCollaborators();
    }

    public Collaborator findOneById(Long id) {
        return collaboratorRepository.findOneById(id).orElseThrow(CollaboratorNotFoundException::new);
    }

    public void updateOneById(Long id, Collaborator collaborator) {
        if (findOneById(id) != null) {
            collaboratorRepository.updateOneById(id, collaborator.getFullName(), collaborator.getCpf());
        }
    }

    public void deleteOneById(Long id) {
        if (findOneById(id) != null) {
            collaboratorRepository.deleteOneById(id);
            collaboratorItemService.removeRelationship();
        }
    }

    public void addCollaboratorItem(Long id, List<Long> items) {
        if (findOneById(id) != null) {
            collaboratorItemService.addAllItems(id, items);
        }
    }

    public void removeCollaboratorItem(Long id, List<Long> items) {
        if (findOneById(id) != null) {
            collaboratorItemService.removeAllItems(id, items);
        }
        collaboratorItemService.removeAllItems(id, items);
    }

    public List<Item> findCollaboratorItems(Long id) {
        if (findOneById(id) != null) {
            return collaboratorItemService.findCollaboratorItems(id);
        }
        return null;
    }
}
