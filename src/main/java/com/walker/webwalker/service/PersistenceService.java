package com.walker.webwalker.service;

import edu.uci.ics.crawler4j.crawler.Page;
import org.jsoup.nodes.Document;

import java.util.Optional;

/**
 * Created by tom on 4/18/2017.
 */
public interface PersistenceService {
    void loadPage(Optional<Document> document);
}
