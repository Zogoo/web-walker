package com.walker.webwalker.dao;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.walker.webwalker.dao.tables.Site.SITE;
import static com.walker.webwalker.dao.tables.Page.PAGE;
import static com.walker.webwalker.dao.tables.Content.CONTENT;

@Repository
public class SiteRepository {

    @Autowired
    DSLContext dsl;

    // CREATE

    @Transactional(rollbackFor = DataAccessException.class)
    public void addSite(Site site) {
        dsl.insertInto(SITE, SITE.SITE_URL)
                .values(site.getSiteUrl())
                .execute();
    }

    @Transactional
    public void addPage(Site site, Page page, Content content) {

        Site origin_stite = fetchSite(site);

        dsl.insertInto(PAGE, PAGE.PAGE_URL, PAGE.SITE_ID)
                .values(page.getPageUrl(), origin_stite.getId())
                .execute();

        Page insterted_page = fetchPage(page);

        dsl.insertInto(CONTENT, CONTENT.PAGE_ID, CONTENT.BASE_CONTENT, CONTENT.PAGE_HTML, CONTENT.PAGE_TXT, CONTENT.PAGE_CSS, CONTENT.PAGE_JS)
                .values(insterted_page.getId(), content.getBaseContent(), content.getPageHtml(), content.getPageTxt(), content.getPageCss(), content.getPageJs())
                .execute();
        return;
    }

    // READ

    @Transactional
    public Site fetchSite(Site site){
        return dsl.selectFrom(SITE).where(SITE.SITE_URL.eq(site.getSiteUrl())).fetchAny().into(Site.class);
    }

    @Transactional
    public Page fetchPage(Page page){
        return dsl.selectFrom(PAGE).where(PAGE.PAGE_URL.eq(page.getPageUrl())).fetchAny().into(Page.class);
    }

    @Transactional
    public List<Content> fetchContent(Page page){
        Page origin_page = dsl.selectFrom(PAGE).where(PAGE.PAGE_URL.eq(page.getPageUrl())).fetchAny().into(Page.class);
        return dsl.selectFrom(CONTENT).where(CONTENT.PAGE_ID.eq(origin_page.getId())).fetch().into(Content.class);
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public List<Site> fetchAllSite(){
        List<Site> allSite = dsl.select().from(SITE).fetch().into(Site.class);
        return allSite;
    }

    //UPDATE

    @Transactional
    public boolean updateSite(Site site, Page page, Content content){

        Site originSite = fetchSite(site);

        dsl.update(SITE)
                .set(SITE.SITE_URL, site.getSiteUrl())
                .where()
                .execute();

        dsl.update(PAGE)
                .set(PAGE.PAGE_URL, page.getPageUrl())
                .set(PAGE.HAS_DIFF, page.getHasDiff())
                .set(PAGE.SITE_ID, originSite.getId())
                .execute();

        Page originPage = dsl.selectFrom(PAGE).where(PAGE.PAGE_URL.eq(page.getPageUrl()).and(PAGE.SITE_ID.eq(site.getId()))).fetchAny().into(Page.class);

        dsl.update(CONTENT)
                .set(CONTENT.PAGE_HTML, content.getPageHtml())
                .set(CONTENT.PAGE_TXT, content.getPageTxt())
                .set(CONTENT.PAGE_CSS, content.getPageCss())
                .set(CONTENT.PAGE_JS, content.getPageJs())
                .set(CONTENT.PAGE_ID, originPage.getId())
                .execute();
        return true;
    }

    // DELETE

    @Transactional
    public boolean removeSite(Site site){
        dsl.deleteFrom(SITE).where(SITE.SITE_URL.eq(site.getSiteUrl())).execute();
        return true;
    }
}
