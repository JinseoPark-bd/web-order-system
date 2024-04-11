package com.dai.wos.baseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(nullable = false)
    private Date createDt;

    @CreatedBy
    //@Column(nullable = false)
    private String createId;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date editDt;

    @LastModifiedBy
    private String editId;

}
