package com.walker.webwalker.service;

import edu.uci.ics.crawler4j.parser.HtmlParseData;
import org.jsoup.Jsoup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.jsoup.nodes.Document;

import javax.annotation.Resource;
import java.io.File;
import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtractorImplTest {

    private Document dummyDocument;

    @Resource(name = "extractor")
    private Extractor extractor;

    @Before
    public void setUp() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("dummy_site.html").getFile());
        dummyDocument = Jsoup.parse(file, "UTF-8");
        dummyDocument.setBaseUri("http://www.tokyo.embassy.mn/home");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parseDocument() {
        extractor.parseDocument(Optional.ofNullable(dummyDocument));
        assertNotNull(extractor.getSite());
        assertNotNull(extractor.getPage());
        assertNotNull(extractor.getContent());
        assertNotNull(extractor.getSite().getSiteUrl());
        assertNotNull(extractor.getPage().getPageUrl());
        assertNotNull(extractor.getContent().getPageHtml());
    }
}