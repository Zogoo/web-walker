package com.walker.webwalker.service;

import com.walker.webwalker.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SiteManagerImpl implements SiteManager {

    @Autowired
    private final Crawler crawler;
    private final String siteUrl;

    public SiteManagerImpl(String aSiteUrl) throws IOException {
        this.siteUrl = aSiteUrl;
    }

    public Boolean registerNewSite(String url){
        Site.builder().siteUrl(url);
        return true;
    }
}
