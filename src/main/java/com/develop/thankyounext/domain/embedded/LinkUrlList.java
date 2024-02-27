package com.develop.thankyounext.domain.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkUrlList {

    List<String> urls;
}
