package com.walker.webwalker.service;

import com.walker.webwalker.dao.Content;
import com.walker.webwalker.dao.Page;
import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dto.Items;
import org.jsoup.nodes.Document;

import java.util.Optional;

public interface Extractor {
    Items parseDocument(Optional<Document> document);
    Site getSite();
    Page getPage();
    Content getContent();
}
