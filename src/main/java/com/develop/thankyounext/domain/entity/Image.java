package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.entity.embedded.GalleryImageList;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    // Relation Association Method
    public void setPost(Post post) {
        this.post = post;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
