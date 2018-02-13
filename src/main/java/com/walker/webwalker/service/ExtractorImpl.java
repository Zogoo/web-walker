package com.walker.webwalker.service;

import com.walker.webwalker.dao.Content;
import com.walker.webwalker.dao.Page;
import com.walker.webwalker.dao.Site;
import com.walker.webwalker.dto.Items;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

@Service("extractor")
public class ExtractorImpl implements Extractor {

    @Setter @Getter private Items items;
    @Setter @Getter private Site site;
    @Setter @Getter private Page page;
    @Setter @Getter private Content content;


    @Override
    public Items parseDocument(Optional<Document> document){
        document.map(this::parseAsItem);
        document.map(this::parseAsSite);
        document.map(this::parseAsPage);
        document.map(this::parseAsContent);
        return items;
    }

    private Items parseAsItem(Document document){

        this.items = Items.builder()
                .hostUrl(document.baseUri())
                .pageHtml(Optional.ofNullable(document.outerHtml()))
                .pageTxt(Optional.ofNullable(document.text()))
                .build();

        return items;
    }

    private Site parseAsSite(Document document){
        URI uriObj = getURIFromURL(document.baseUri());
        this.site = Site.builder()
                .siteUrl(uriObj.getScheme() + "://" + uriObj.getHost())
                .build();
        return site;
    }

    private Page parseAsPage(Document document){
        this.page = Page.builder()
                .pageUrl(getURIFromURL(document.baseUri()).getPath())
                .build();
        return page;
    }

    private Content parseAsContent(Document document){
        this.content = Content.builder()
                .baseContent(true)
                .pageTxt(document.text())
                .pageHtml(document.html())
                .build();
        return content;
    }

    private URI getURIFromURL(String url){
        URI parsedUrl;
        parsedUrl = URI.create(url);
        return parsedUrl;
    }
}
