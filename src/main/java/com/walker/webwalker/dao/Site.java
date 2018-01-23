package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.walker.webwalker.dao.tables.Site.SITE;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Site {
    @NotNull
    private String siteUrl;
    private String pageHtml;
    private String pageCss;
    private String pageJs;

    @Autowired
    DSLContext dslContext;

    @Transactional(rollbackFor = DataAccessException.class)
    public void addSite() {
        dslContext.insertInto(SITE, SITE.SITE_URL, SITE.PAGE_HTML, SITE.PAGE_CSS, SITE.PAGE_JS)
                .values(siteUrl, pageHtml, pageCss, pageJs)
                .execute();
    }
}
