package com.walker.webwalker.controller;

import com.walker.webwalker.service.ClientConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebWalkerController {

    private ClientConfiguration configuration = new ClientConfiguration();

    @RequestMapping("/")
    public String main(Map<String, Object> model){
        model.put("agent", configuration.getAgent());
        return "main";
    }
}