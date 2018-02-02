package com.walker.webwalker.service;

import org.jsoup.nodes.Document;

import java.util.Optional;

public interface Extractor {
    void parseDocument(Optional<Document> document);
}
