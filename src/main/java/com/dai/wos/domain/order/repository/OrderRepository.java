package com.dai.wos.domain.order.repository;

import com.dai.wos.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 유저가 작성 한 주문을 화주아이디, 거래처아이디, 원하는 날짜 조회
    @Query("SELECT o FROM OJT_OMS_ORDER_JPA o " +
            "WHERE o.createId = :userId " +
            "AND o.owner.ownerId = :ownerId " +
            "AND o.account.accountId = :accountId " +
            "AND o.createDt BETWEEN :startDate AND :endDate " +
            "ORDER BY o.createDt DESC, o.seq DESC")
    List<Order> findByDateBetweenDesc(
            @Param("userId") String userId,
            @Param("ownerId") String ownerId,
            @Param("accountId")String accountId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );
}
