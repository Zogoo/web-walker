package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("crawler")
public class CrawlerImpl implements Crawler {

    private Document document;
    private Extractor extractor;
    private ClientConfiguration config = new ClientConfiguration();

    @Override
    public Document visitUrl(String url) throws IOException {
        document = Jsoup.connect(url).get();
        return document;
    }

}
