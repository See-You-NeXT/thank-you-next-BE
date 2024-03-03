package com.develop.thankyounext.domain.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUrlList {

    List<String> urls = new ArrayList<>();

    public void addUrl(String url) {
        urls.add(url);
    }
}
