package com.walker.webwalker.service;

import com.walker.webwalker.dto.Items;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Data
@Service("extractor")
public class ExtractorImpl implements Extractor {

    private Items items;

    @Override
    public Items parseDocument(Optional<Page> page){
        page.map(this::parseAsString);
        return items;
    }

    private Items parseAsString(Page page){

        if (page.getParseData() instanceof HtmlParseData){

            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            this.items = Items.builder()
                    .url(page.getWebURL().getURL())
                    .html(Optional.ofNullable(htmlParseData.getHtml()))
                    .page_text(Optional.ofNullable(htmlParseData.getText()))
                    .build();
        }

        return items;
    }


}
