package com.walker.webwalker.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class SiteTest {

    private Site site;

    private String protocol;
    private String base_url;
    private String parameter;

    @Before
    public void setUp() throws Exception {
        protocol = "https://";
        base_url = "test.example.com";
        parameter = "/test&id=1";
        site = Site.builder().siteUrl(protocol + base_url + parameter).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSiteUrl() { ;
        assertEquals(base_url, site.getSiteUrl());
    }
}