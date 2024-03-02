package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.entity.base.BaseEntity;
import com.develop.thankyounext.domain.entity.embedded.PostImageList;
import com.develop.thankyounext.domain.enums.PostEnum;
import com.develop.thankyounext.domain.enums.SolvedEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id")
    private Vote vote;

    @Builder.Default
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @Column
    @Embedded
    private PostImageList imageList;

    // Relation Association Method
    public void setMember(Member member) {
        this.member = member;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public void setImageList(PostImageList imageList) {
        this.imageList = imageList;
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
