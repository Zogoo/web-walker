package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Data
@Builder
public class Site {
    private String siteUrl;
    private String pageJs;
    private String PageCss;
    private String pageHtml;
}
