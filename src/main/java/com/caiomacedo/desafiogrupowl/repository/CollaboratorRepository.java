package com.caiomacedo.desafiogrupowl.repository;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO COLLABORATORS (NAME, CPF) VALUES (?1, ?2)", nativeQuery = true)
    void createCollaborator(String s1, String s2);

    @Query(value = "SELECT * FROM COLLABORATORS c WHERE c.ID = ?", nativeQuery = true)
    Optional<Collaborator> findOneById(Long l);

    @Modifying
    @Transactional
    @Query(value = "UPDATE COLLABORATORS c SET c.NAME = ?2, c.CPF = ?3 WHERE c.ID = ?1", nativeQuery = true)
    void updateOneById(Long l, String s1, String s2);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM COLLABORATORS WHERE ID = ?", nativeQuery = true)
    void deleteOneById(Long l);
}
