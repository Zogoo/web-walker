package com.walker.webwalker.service;

import org.jsoup.nodes.Document;

public interface Extractor {
    void parseDocument(Document document);
}
