package com.caiomacedo.desafiogrupowl.repository;

import com.caiomacedo.desafiogrupowl.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO COLLABORATORS (FULL_NAME, CPF) VALUES (?1, ?2)", nativeQuery = true)
    void createOne(String s1, String s2);

    @Query(value = "SELECT * FROM COLLABORATORS", nativeQuery = true)
    List<Collaborator> findAllCollaborators();

    @Query(value = "SELECT * FROM COLLABORATORS c WHERE c.ID = ?", nativeQuery = true)
    Optional<Collaborator> findOneById(Long l);

    @Query(value = "SELECT * FROM COLLABORATORS c WHERE c.CPF = ?", nativeQuery = true)
    Optional<Collaborator> findOneByCpf(String s);

    @Modifying
    @Transactional
    @Query(value = "UPDATE COLLABORATORS c SET c.FULL_NAME = ?2, c.CPF = ?3 WHERE c.ID = ?1", nativeQuery = true)
    void updateOneById(Long l, String s1, String s2);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM COLLABORATORS WHERE ID = ?", nativeQuery = true)
    void deleteOneById(Long l);

    @Query(value = "SELECT c.FULL_NAME, c.CPF, GROUP_CONCAT(i.NAME SEPARATOR '|') FROM COLLABORATORS c " +
            "INNER JOIN COLLABORATOR_ITEMS ci ON c.ID  = ci.COLLABORATOR_ID " +
            "INNER JOIN ITEMS i ON  i.ID = ci.ITEM_ID GROUP BY c.FULL_NAME ORDER BY c.ID", nativeQuery = true)
    List<String> findCollaboratorItems();
}
