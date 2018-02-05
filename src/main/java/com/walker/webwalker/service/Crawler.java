package com.walker.webwalker.service;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

public interface Crawler {
    boolean shouldVisit(Page refferingPage, WebURL url);
    void visit(Page page);
}
