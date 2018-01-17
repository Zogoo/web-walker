package com.walker.webwalker.service;

import com.walker.webwalker.dto.SiteDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import com.walker.webwalker.service.Node;

@Service
public class CrawlerImpl implements Crawler{

    private Document currentPage;
    private Map<String, Element> links;
    private HashMap<String, String> images;
    private Node<String> mainUrl;
    private ClientConfiguration config;

    public CrawlerImpl(String siteUrl) throws IOException {
        this.config = new ClientConfiguration();
        this.currentPage = Jsoup.connect(siteUrl).get();
        this.mainUrl = new Node<String>(siteUrl);
    }

    public Document moveToNextLink(){

        return null;
    }

    public Document backToPrevousLink(){
        return null;
    }

    public SiteDocument extractAll(){
        Extractor extractor = new ExtractorImpl(this.currentPage);
        extractor.getBody().toString();
        return null;
    }
}