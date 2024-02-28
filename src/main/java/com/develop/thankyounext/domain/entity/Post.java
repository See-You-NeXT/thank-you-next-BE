package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.embedded.ImageUrlList;
import com.develop.thankyounext.domain.entity.base.BaseEntity;
import com.develop.thankyounext.domain.enums.PostEnum;
import com.develop.thankyounext.domain.enums.SolvedEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
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
    @Enumerated(value = EnumType.STRING)
    private PostEnum dType;

    @Column
    @Enumerated(value = EnumType.STRING)
    private SolvedEnum isSolved = SolvedEnum.FALSE;

    @Column
    @Embedded
    private ImageUrlList imageUrlList;

    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id")
    private Vote vote;

    // Relation Association Method
    public void setMember(Member member) {
        this.member = member;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}
