package com.walker.webwalker.dto;

import lombok.Data;

import java.net.MalformedURLException;
import java.net.URL;

@Data
public class NewSite {

    private URL urlObj;
    private String url;

    public String getMainUrl(){
        parseUrl();
        return urlObj.getProtocol() + "://" + urlObj.getHost();
    }

    public String getProtocol(){
        parseUrl();
        return urlObj.getProtocol();
    }

    public String getHost(){
        parseUrl();
        return urlObj.getHost();
    }

    public String getPath(){
        parseUrl();
        return urlObj.getPath();
    }

    private void parseUrl(){
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
