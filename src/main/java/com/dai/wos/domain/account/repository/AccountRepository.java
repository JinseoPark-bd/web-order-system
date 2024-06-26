package com.dai.wos.domain.account.repository;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findAll();

    /**
     * 아이디 또는 이름으로 거래처 검색
     * @param keyword
     * @return List<Account>
     */
    @Query("SELECT a FROM OJT_OMS_ACCOUNT_JPA a " +
            "WHERE (:keyword IS NULL OR LOWER(a.accountId) LIKE CONCAT('%', LOWER(:keyword), '%')) " +
            "OR (:keyword IS NULL OR LOWER(a.accountNm) LIKE CONCAT('%', LOWER(:keyword), '%'))")
    List<Account> findByKeyword(@Param("keyword") String keyword);

}
