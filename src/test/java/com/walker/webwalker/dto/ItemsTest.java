package com.walker.webwalker.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsTest {

    private Items items;

    private String protocol;
    private String base_url;
    private String parameter;

    @Before
    public void setUp() throws Exception {
        protocol = "https://";
        base_url = "test.example.com";
        parameter = "/test&id=1";
        items = Items.builder().hostUrl(protocol + base_url + parameter).build();
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getHostUrl() {
        assertEquals(base_url, items.getHostUrl());
    }

    @Test
    public void getPageUrl() {
        assertEquals(parameter, items.getPageUrl());
    }
}