package com.walker.webwalker.service;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import static org.slf4j.LoggerFactory.getLogger;

public class CrawlerImpl extends WebCrawler {

    private static final Logger logger = getLogger(CrawlerImpl.class);

    private static Pattern FILE_ENDING_EXCLUSION_PATTERN = Pattern.compile(".*(\\.(" +
            "css|js" +
            "|bmp|gif|jpe?g|JPE?G|png|tiff?|ico|nef|raw" +
            "|mid|mp2|mp3|mp4|wav|wma|flv|mpe?g" +
            "|avi|mov|mpeg|ram|m4v|wmv|rm|smil" +
            "|pdf|doc|docx|pub|xls|xlsx|vsd|ppt|pptx" +
            "|swf" +
            "|zip|rar|gz|bz2|7z|bin" +
            "|xml|txt|java|c|cpp|exe" +
            "))$");

    private ClientConfiguration config = new ClientConfiguration();

    private static PersistenceService persistenceService;

    public CrawlerImpl(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public boolean shouldVisit(Page refferingPage, WebURL url){
        String href = url.getURL().toLowerCase();
        return !FILE_ENDING_EXCLUSION_PATTERN.matcher(href).matches();
    }

    @Override
    public void visit(Page page){
        String url = page.getWebURL().getURL();

        logger.info("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData){
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parseBodyFragment(html);

            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            logger.info("Text length: " + text.length());
            logger.info("Html lenght: " + html.length());
            logger.info("Number of outgoing links: " + links.size());

            persistenceService.loadPage(Optional.ofNullable(doc));
        }
    }
}
