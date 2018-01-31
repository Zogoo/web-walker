package com.walker.webwalker.controller;

import com.walker.webwalker.dto.NewSite;
import com.walker.webwalker.service.ClientConfiguration;
import com.walker.webwalker.service.Crawler;
import com.walker.webwalker.service.SiteManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@EnableWebMvc
@Controller
public class WebWalkerController {

    @Resource(name = "config")
    private ClientConfiguration configuration;

    @Resource(name = "crawler")
    private Crawler crawler;

    @Resource(name = "siteManager")
    private SiteManager siteManager;

    @RequestMapping(value = "/", method = GET)
    public String home(Map<String, Object> model){
        model.put("agent", configuration.getAgent());
        return "main";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addNewSite (@Valid final NewSite aNewSite, final HttpServletRequest request){
        siteManager.addNewSite(aNewSite);
        return null;
    }
}