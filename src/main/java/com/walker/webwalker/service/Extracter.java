package com.walker.webwalker.service;

import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Data
public class Extracter {

    private Document document;
    private Element body;

    public Extracter(Document document){
        body = document.body();
    }
}
