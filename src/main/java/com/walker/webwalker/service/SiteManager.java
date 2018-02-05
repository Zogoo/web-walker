package com.walker.webwalker.service;

import com.walker.webwalker.dto.NewSite;

import java.util.Map;

public interface SiteManager {
    boolean addNewSite(NewSite aNewSite);
    Map<String, String> readAndCompare() throws Exception;
}
