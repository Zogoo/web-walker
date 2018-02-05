package com.walker.webwalker.dao;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.walker.webwalker.dao.tables.Site.SITE;

@Repository
public class SiteRepository {

    @Autowired
    DSLContext dslContext;

    @Transactional(rollbackFor = DataAccessException.class)
    public void addSite(Site site) {

        dslContext.insertInto(SITE, SITE.SITE_URL, SITE.PAGE_HTML, SITE.PAGE_CSS, SITE.PAGE_JS)
                .values(site.getSiteUrl(), site.getPageHtml(), site.getPageCss(), site.getPageJs())
                .execute();
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public List<Site> readAllSite(){
        List<Site> allSite = dslContext.select().from(SITE).fetch().into(Site.class);
        return allSite;
    }

    @Transactional
    public boolean updateSite(Site site){
        dslContext.update(SITE)
                .set(SITE.PAGE_HTML, site.getPageHtml())
                .where(SITE.SITE_URL.eq(site.getSiteUrl()));
        return true;
    }
}
