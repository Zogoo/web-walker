package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dao.SiteRepository;
import com.walker.webwalker.dto.NewSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("siteManager")
@Transactional
public class SiteManagerImpl implements SiteManager {

    @Resource(name = "extractor")
    private Extractor extractor;

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public boolean addNewSite(NewSite newSite){
        siteRepository.addSite(Site.builder().siteUrl(newSite.getUrl()).build());
        return true;
    }

    @Override
    public List<Site> readAllSite(){
        return siteRepository.readAllSite();
    }
}
