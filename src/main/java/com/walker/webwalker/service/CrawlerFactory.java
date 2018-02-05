package com.walker.webwalker.service;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

public class CrawlerFactory implements CrawlController.WebCrawlerFactory {

    PersistenceService persistenceService;

    public CrawlerFactory(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public WebCrawler newInstance() throws Exception {
        return new CrawlerImpl(persistenceService);
    }
}
