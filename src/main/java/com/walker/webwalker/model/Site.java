package com.walker.webwalker.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Site {
    private String siteUrl;
    private String pageHtml;
    private String pageCss;
    private String pageJs;
}
