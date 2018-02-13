package com.walker.webwalker.controller;

import com.walker.webwalker.dto.NewSite;
import com.walker.webwalker.service.ClientConfiguration;
import com.walker.webwalker.service.Crawler;
import com.walker.webwalker.service.SiteManager;
import com.walker.webwalker.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@EnableWebMvc
@Controller
public class WebWalkerController {

    @Autowired
    private MessageSource messages;

    @Resource(name = "config")
    private ClientConfiguration configuration;

    @Autowired
    private SiteManager siteManager;

    @RequestMapping(value = "/", method = GET)
    public String home(Map<String, Object> model){
        model.put("agent", configuration.getAgent());
        return "main";
    }

    @RequestMapping(value = "/add", method = POST)
    @ResponseBody
    public GenericResponse addNewSite (@Valid final NewSite aNewSite, final HttpServletRequest request){
        siteManager.addNewSite(aNewSite);
        return new GenericResponse("success");
    }

    @RequestMapping(value = "compare", method = GET)
    public GenericResponse compare(final HttpServletRequest request, final Model model) throws IOException {
        Locale locale = request.getLocale();
        try {
            siteManager.readAndCompare();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new GenericResponse("success");
    }
}