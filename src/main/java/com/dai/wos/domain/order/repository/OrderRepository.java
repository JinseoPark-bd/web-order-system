package com.dai.wos.domain.order.repository;

import com.dai.wos.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 유저가 작성 한 주문을 거래처와
    @Query("SELECT o FROM OJT_OMS_ORDER_JPA o " +
            "WHERE o.owner = :ownerId AND o.account = :accountId " +
            "AND o.createDt BETWEEN :startDate AND :endDate " +
            "ORDER BY o.createDt DESC, o.seq DESC")
    List<Order> findByDateBetweenDesc(
            String ownerId,
            String accountId,
            LocalDateTime startDate,
            LocalDateTime endDate
    );
}
