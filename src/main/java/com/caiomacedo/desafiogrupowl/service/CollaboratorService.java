package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.entity.dto.CollaboratorItems;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorAlreadyExistsException;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorNotFoundException;
import com.caiomacedo.desafiogrupowl.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(collaboratorRepository.findOneByCpf(collaborator.getCpf()).isPresent()){
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
        if(findOneById(id) != null){
            collaboratorRepository.updateOneById(id, collaborator.getFullName(), collaborator.getCpf());
        }
    }

    public void deleteOneById(Long id) {
        if(findOneById(id) != null) {
            collaboratorRepository.deleteOneById(id);
        }
    }

    public void addCollaboratorItem(Long id, List<Long> items){
        findOneById(id);
        collaboratorItemService.registerAllItems(id, items);
    }

    public List<CollaboratorItems> findCollaboratorAndItems() {
        List<CollaboratorItems> collaboratorItems = new ArrayList<>();
        collaboratorRepository.findCollaboratorItems().forEach(ci -> {
            var data = ci.split(",");
            var items = data[2].split("\\|");
            collaboratorItems.add(new CollaboratorItems(data[0], data[1], items));
        });
        return collaboratorItems;
    }
}
