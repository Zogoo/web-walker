package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Site {
    @NotNull
    private String siteUrl;
    private String pageHtml;
    private String pageCss;
    private String pageJs;
}
