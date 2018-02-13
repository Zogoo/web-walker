package com.walker.webwalker.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteRepositoryTest {

    @Resource
    private SiteRepository siteRepository;
    private Site site;
    private Page page;
    private Content content;
    private final String url = "http://www.test.com/home";
    private final String site_url = urlParser(url).getHost();
    private final String page_url = urlParser(url).getPath();

    @Before
    public void setUp() throws Exception {
        site = Site.builder()
                .siteUrl(site_url)
                .build();
        page = Page.builder()
                .siteId(site.getId())
                .pageUrl(page_url)
                .hasDiff(false)
                .build();
        content = Content.builder()
                .baseContent(true)
                .pageHtml("<html><body>test</body></html>")
                .pageTxt("test")
                .pageId(page.getId())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        siteRepository.removeSite(Site.builder().siteUrl(site_url).build());
    }

    @Test
    public void addSiteTest(){
        siteRepository.addSite(site);
        assertEquals(siteRepository.fetchAllSite().size(), 1);
    }

    @Test
    public void addPageTest(){
        Page current_page = Page.builder().pageUrl(page_url).build();
        siteRepository.addSite(site);
        siteRepository.addPage(site, page, content);
        assertEquals(siteRepository.fetchPage(current_page).getPageUrl(), page_url);
        assertEquals(siteRepository.fetchContent(current_page).size(), 1);
    }

    @Test
    public void fetchSite(){
        siteRepository.addSite(site);
        Site test_site = siteRepository.fetchSite(site);
        assertEquals(test_site.getSiteUrl(), site.getSiteUrl());
    }

    @Test
    public void fetchNotExistingSite(){
        Site test_site = siteRepository.fetchSite(site);
        assertNull(test_site);
    }

    @Test
    public void removeSites(){
        siteRepository.addSite(site);
        siteRepository.addPage(site, page, content);
        siteRepository.fetchAllSite().forEach((site) -> {
            siteRepository.removeSite(site);
        });
        assertEquals(siteRepository.fetchAllSite().size(), 0);
    }

    private URL urlParser(String url){
        URL parsedUrl;
        try {
            parsedUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        return parsedUrl;
    }

}