package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.embedded.LinkUrlList;
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
    @Enumerated(value = EnumType.STRING)
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

    @Column
    @Embedded
    private LinkUrlList linkUrlList;

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void updateLinkUrlList(LinkUrlList linkUrlList) {
        this.linkUrlList = linkUrlList;
    }
}
