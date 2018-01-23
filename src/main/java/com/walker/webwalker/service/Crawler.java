package com.walker.webwalker.service;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface Crawler {
    Document visitUrl(String url) throws IOException;
}
