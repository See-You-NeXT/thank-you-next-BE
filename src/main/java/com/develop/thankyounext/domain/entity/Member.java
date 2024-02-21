package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.entity.base.BaseEntity;
import com.develop.thankyounext.domain.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private UserRoleEnum role;

    @Column(unique = true)
    @Size(max = 50)
    @NotNull
    private String email;

    @Column
    @Size(max = 50)
    @NotNull
    private String password;

    @Column
    @Size(max = 10)
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    @NotNull
    @Size(min = 8, max = 8)
    private String studentId;

    @Column
    @Size(max = 100)
    private String refreshToken;
}
