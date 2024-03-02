package com.develop.thankyounext.domain.entity.embedded;

import com.develop.thankyounext.domain.entity.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryImageList {

    @Builder.Default
    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    public void addImage(Image image) {
        this.imageList.add(image);
    }
}
