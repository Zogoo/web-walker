package com.walker.webwalker.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerImplTest {

    @Before
    public void setUp() throws Exception {
        File file = ResourceUtils.getFile(this.getClass().getResource("/test/resources/dummy_site.html"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void crawlerImpl() {


    }
}