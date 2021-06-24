package com.caiomacedo.desafiogrupowl.service;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import com.caiomacedo.desafiogrupowl.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorService(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    public void createCollaborator(Collaborator collaborator) {
        collaboratorRepository.createCollaborator(collaborator.getName(), collaborator.getCpf());
    }

    public Collaborator findCollaboratorById(Long id) {
        return collaboratorRepository.findOneById(id).orElse(null);
    }

    public void updateCollaboratorById(Long id, Collaborator collaborator) {
        collaboratorRepository.updateOneById(id, collaborator.getName(), collaborator.getCpf());
    }

    public void deleteCollaboratorById(Long id) {
        collaboratorRepository.deleteOneById(id);
    }
}
