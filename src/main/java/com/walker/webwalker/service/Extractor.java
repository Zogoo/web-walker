package com.walker.webwalker.service;

import com.walker.webwalker.dto.Items;
import edu.uci.ics.crawler4j.crawler.Page;

import java.util.Optional;

public interface Extractor {
    Items parseDocument(Optional<Page> document);
}
