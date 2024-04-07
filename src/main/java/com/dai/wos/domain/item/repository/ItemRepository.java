package com.dai.wos.domain.item.repository;

import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findAllByOwner(Owner owner);

    @Query("SELECT i FROM OJT_OMS_ITEM_JPA i WHERE i.owner = :ownerId")
    List<Item> findAllByOwnerID(String ownerId);
}
