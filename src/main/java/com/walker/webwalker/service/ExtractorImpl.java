package com.walker.webwalker.service;

import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Data
@Service("extractor")
public class ExtractorImpl implements Extractor {

    private Document document;
    private Element body;
    private Element header;

    @Override
    public void parseDocument(Document document){
        this.body = document.body();
    }
}
