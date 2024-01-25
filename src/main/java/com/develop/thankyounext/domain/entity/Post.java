package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.entity.base.BaseEntity;
import com.develop.thankyounext.domain.enums.PostEnum;
import com.develop.thankyounext.domain.enums.SolvedEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 50)
    private String title;

    @Column
    @NotNull
    @Size(max = 2000)
    private String content;

    @Column
    @NotNull
    private PostEnum dType;

    @Column
    private SolvedEnum isSolved = SolvedEnum.FALSE;

    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id")
    private Vote vote;
}