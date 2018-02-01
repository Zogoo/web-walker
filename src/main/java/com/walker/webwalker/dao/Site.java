package com.walker.webwalker.dao;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.walker.webwalker.dao.tables.Site.SITE;

@Repository
public class Site {

    @Autowired
    DSLContext dslContext;

    @Transactional(rollbackFor = DataAccessException.class)
    public void addSite(SiteRepository siteRepository) {

        dslContext.insertInto(SITE, SITE.SITE_URL, SITE.PAGE_HTML, SITE.PAGE_CSS, SITE.PAGE_JS)
                .values(siteRepository.getSiteUrl(), siteRepository.getPageHtml(), siteRepository.getPageCss(), siteRepository.getPageJs())
                .execute();
    }
}
