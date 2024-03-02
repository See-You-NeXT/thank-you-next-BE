package com.develop.thankyounext.domain.entity;

import com.develop.thankyounext.domain.entity.base.BaseEntity;
import com.develop.thankyounext.domain.entity.embedded.GalleryImageList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Gallery extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 50)
    private String title;

    @Embedded
    private GalleryImageList imageList;

    public void setImageList(GalleryImageList imageList) {
        this.imageList = imageList;
    }
}
