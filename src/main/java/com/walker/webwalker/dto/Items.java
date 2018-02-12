package com.walker.webwalker.dto;

import lombok.Builder;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Data
@Builder
public class Items {

    private String hostUrl;
    private Optional<String> pageHtml;
    private Optional<String> pageTxt;
    private Optional<String> pageJs;
    private Optional<String> pageCSS;

    public String getHostUrl(){
        return urlParser(this.hostUrl).getHost();
    }

    public String getPageUrl(){
        return urlParser(this.hostUrl).getPath();
    }

    private URL urlParser(String url){
        URL parsedUrl;
        try {
            parsedUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        return parsedUrl;
    }
}
