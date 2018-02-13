package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dao.SiteRepository;
import com.walker.webwalker.dto.NewSite;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Transactional
public class SiteManagerImpl implements SiteManager {

    @Autowired
    private SiteRepository siteRepository;

    @Resource(name = "storage")
    PersistenceService persistenceService;

    @Override
    public boolean addNewSite(NewSite newSite){
        siteRepository.addSite(Site.builder().siteUrl(newSite.getMainUrl()).build());
        return true;
    }

    @Override
    public Map<String, String> readAndCompare() throws Exception {
        String crawlStorageFolder = "/home/zogoo/data/crawl/root";
        int numberOfCrawlers = 2;
        int maxPagesToFetch = 2;
        // crawler4j waits at least 200 milliseconds between requests
        int politenessDelay = 10;

        CrawlConfig config = new CrawlConfig();

        config.setIncludeHttpsPages(true);
        config.setMaxPagesToFetch(maxPagesToFetch);
        config.setPolitenessDelay(100);
        config.setPolitenessDelay(politenessDelay);

        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);


        siteRepository.fetchAllSite().forEach((site) -> {
            controller.addSeed(site.getSiteUrl());
        });

        CrawlerFactory factory = new CrawlerFactory(persistenceService);

        controller.start(factory, numberOfCrawlers);
        return null;
    }
}
