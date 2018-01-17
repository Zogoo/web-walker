package com.walker.webwalker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CrawlerImpl {

    private ClientConfiguration config = new ClientConfiguration();
    private Comparison comparison = new Comparison();

    public void CrawlerImpl() throws IOException {
        Document document = Jsoup.connect(config.getHostUrl()).get();
        Extracter extracter = new Extracter(document);

        extracter.getBody().toString();
    }
}
