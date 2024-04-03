package com.dai.wos.domain.item.entity;

import com.dai.wos.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table(indexes = @Index(name="IX_non_fk_item_user_id", columnList = "user_id"))
//@Entity
public class NonFkItem {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)) // FK 설정 X
    private User user;

    @Builder
    private NonFkItem (String id, User user) {
        this.id = id;
        this.user = user;
    }
}
