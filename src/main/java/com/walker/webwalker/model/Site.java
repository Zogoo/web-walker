package com.walker.webwalker.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Site {
    private String site_url;
    private String page_html;
    private String page_css;
    private String page_js;
}
