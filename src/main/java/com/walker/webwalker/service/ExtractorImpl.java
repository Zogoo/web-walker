package com.walker.webwalker.service;

import com.walker.webwalker.dto.Items;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service("extractor")
public class ExtractorImpl implements Extractor {

    private String html;
    private String body;
    private String header;
    private Items items;

    @Override
    public void parseDocument(Optional<Document> document){

        document.map(this::parseAsString);
        document.map(this::getListLinks);

        return;
    }

    private Items getListLinks(Document doc){
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        this.items = Items.builder()
                .links(Optional.ofNullable(links))
                .medias(Optional.ofNullable(media))
                .imports(Optional.ofNullable(imports)).build();
        return items;
    }

    private boolean parseAsString(Document doc) {
        this.html = doc.outerHtml();
        this.body = doc.body().outerHtml();
        this.header = doc.head().outerHtml();
        return true;
    }
}
