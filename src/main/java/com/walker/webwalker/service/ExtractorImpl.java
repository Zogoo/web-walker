package com.walker.webwalker.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ExtractorImpl implements Extractor {

    public ExtractorImpl(Document currentPage) {
    }

    public Element getBody(){
        return null;
    }
}
