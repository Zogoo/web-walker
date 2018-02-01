package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dao.SiteRepository;
import com.walker.webwalker.dto.NewSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("siteManager")
@Transactional
public class SiteManagerImpl implements SiteManager {

    @Resource(name = "extractor")
    private Extractor extractor;

    @Autowired
    private Site site;

    @Override
    public boolean addNewSite(NewSite newSite){
        site.addSite(SiteRepository.builder().siteUrl(newSite.getUrl()).build());
        return true;
    }
}
