package com.walker.webwalker.dto;

import lombok.Builder;
import lombok.Data;
import org.jsoup.select.Elements;

import java.util.Optional;

@Data
@Builder
public class Items {

    private Optional<Elements> links;
    private Optional<Elements> medias;
    private Optional<Elements> imports;
}
