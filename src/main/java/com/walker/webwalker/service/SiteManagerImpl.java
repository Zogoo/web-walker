package com.walker.webwalker.service;

import com.walker.webwalker.dto.SiteDocument;
import com.walker.webwalker.model.Site;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SiteManagerImpl implements SiteManager {

    private final Crawler crawler ;
    private final String siteUrl;

    public SiteManagerImpl(String aSiteUrl) throws IOException {
        this.siteUrl = aSiteUrl;
        this.crawler = new CrawlerImpl(this.siteUrl);
    }

    public Boolean registerNewSite(String url){
        Site.builder().siteUrl(url);
        return true;
    }
}
