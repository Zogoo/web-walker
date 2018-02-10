package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dao.SiteRepository;
import com.walker.webwalker.dto.Items;
import edu.uci.ics.crawler4j.crawler.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class Storage implements PersistenceService{

    @Autowired
    private SiteRepository siteRepository;

    @Resource(name = "extractor")
    private Extractor extractor;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void loadPage (Optional<Page> page){
        Items items = extractor.parseDocument(page);
        Site site = Site.builder()
                        .siteUrl(items.getHost_url())
                        .build();
    }

}
