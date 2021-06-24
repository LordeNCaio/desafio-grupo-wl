package com.caiomacedo.desafiogrupowl.repository;

import com.caiomacedo.desafiogrupowl.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ITEMS (NAME) VALUES (?)", nativeQuery = true)
    void createItem(String s);

    @Query(value = "SELECT * FROM ITEMS i WHERE i.ID = ?", nativeQuery = true)
    Optional<Item> findOneById(Long l);

    @Query(value = "SELECT * FROM ITEMS i WHERE i.NAME = ?", nativeQuery = true)
    Optional<Item> findOneByName(String s);

    @Query(value = "SELECT * FROM ITEMS", nativeQuery = true)
    List<Item> findAllItems();

    @Modifying
    @Transactional
    @Query(value = "UPDATE ITEMS i SET i.NAME = ?2 WHERE i.ID = ?1", nativeQuery = true)
    void updateOneById(Long l, String s);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ITEMS WHERE ID = ? ", nativeQuery = true)
    void deleteOneById(Long l);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO collaborator_items (COLLABORATOR_ID, ITEMS_ID) VALUES (?1, ?2)", nativeQuery = true)
    void registerCollaboratorItem(Long l1, Long l2);
}
