package com.walker.webwalker.service;

import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dto.NewSite;

import java.util.List;

public interface SiteManager {
    boolean addNewSite(NewSite aNewSite);
    List<Site> readAllSite();
}
