package com.walker.webwalker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class Items {

    private Optional<String> html;
    private String url;
    private Optional<String> page_text;
}
