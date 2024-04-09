package com.dai.wos.domain.item.repository;

import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findAllByOwner(Owner owner);

    Optional<Item> findById(String itemId);

    // 사용자의 화주에 맞는 상품 리스트
    @Query("SELECT i FROM OJT_OMS_ITEM_JPA i " +
            "WHERE i.owner = :ownerId")
    List<Item> findAll(String ownerId);

    // 화주ID + 상품ID + 카테고리ID
    @Query("SELECT i FROM OJT_OMS_ITEM_JPA i " +
            "WHERE i.owner =: ownerId " +
            "AND (:itemId IS NULL OR i.itemId =: itemId  " +
            "AND (:cateId IS NULL OR i.category =: cateId")
    List<Item> findByCateIdAndItemID(String ownerId, String itemId, String cateId);

    // 상품ID 또는 상품 이름으로 검색하기
    @Query("SELECT i FROM OJT_OMS_ITEM_JPA i " +
            "WHERE i.owner.ownerId = :ownerId " +
            "AND (:categoryId IS NULL OR i.category.categoryId = :categoryId) " +
            "AND (:keyword IS NULL OR LOWER(i.itemId) LIKE CONCAT('%', LOWER(:keyword), '%') " +
            "OR (:keyword IS NULL OR LOWER(i.itemName) LIKE CONCAT('%', LOWER(:keyword), '%')")
    List<Item> findByKeyword(String ownerId, String categoryId, String keyword);

}
