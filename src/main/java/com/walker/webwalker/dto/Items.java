package com.walker.webwalker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class Items {

    private String host_url;
    private String parameter;
    private Optional<String> page_html;
    private Optional<String> page_text;
}
