package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dto.NewSite;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("siteManager")
public class SiteManagerImpl implements SiteManager {

    private Site site;

    @Resource(name = "extractor")
    private Extractor extractor;

    @Override
    public boolean addNewSite(NewSite newSite){
        site.builder().siteUrl(newSite.getUrl()).build().addSite();
        return true;
    }
}
