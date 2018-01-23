package com.walker.webwalker.controller;

import com.walker.webwalker.dto.NewSite;
import com.walker.webwalker.service.ClientConfiguration;
import com.walker.webwalker.service.Crawler;
import com.walker.webwalker.service.SiteManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class WebWalkerController {

    @Resource(name = "config")
    private ClientConfiguration configuration;

    @Resource(name = "crawler")
    private Crawler crawler;

    @Resource(name = "siteManager")
    private SiteManager siteManager;

    @RequestMapping(value = "/", method = GET)
    public String main(Map<String, Object> model){
        model.put("agent", configuration.getAgent());
        return "main";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addNewSite (@RequestBody NewSite aNewSite){
        siteManager.addNewSite(aNewSite);
        return null;
    }
}