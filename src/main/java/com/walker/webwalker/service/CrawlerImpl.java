package com.walker.webwalker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Optional;

@Service("crawler")
public class CrawlerImpl implements Crawler {

    private Document document;

    @Resource(name = "extractor")
    private Extractor extractor;

    private ClientConfiguration config = new ClientConfiguration();

    @Override
    public Document visitUrl(String url) throws IOException {
        document = Jsoup.connect(url).userAgent(config.getAgent()).get();
        extractor.parseDocument(Optional.ofNullable(document));
        return document;
    }
}
