package com.walker.webwalker.service;

import com.walker.webwalker.dao.Page;
import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dao.SiteRepository;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class Storage implements PersistenceService{

    @Resource
    private SiteRepository siteRepository;

    @Resource(name = "extractor")
    private Extractor extractor;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void loadPage (Optional<Document> document){
        extractor.parseDocument(document);
        Site existedUrl = siteRepository.fetchSite(extractor.getSite());

        if (existedUrl == null) {
            saveSiteContent(siteRepository);
        }
        else{
            Page existing_page = siteRepository.fetchPage(extractor.getPage());
            if (existing_page == null){
                siteRepository.addPage(
                        extractor.getSite(),
                        extractor.getPage(),
                        extractor.getContent());
            }
        }
    }

    private void saveSiteContent(SiteRepository siteRepository){
        siteRepository.addSite(extractor.getSite());
        siteRepository.addPage(
                extractor.getSite(),
                extractor.getPage(),
                extractor.getContent());
    }

}
