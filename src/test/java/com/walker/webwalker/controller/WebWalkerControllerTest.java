package com.walker.webwalker.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebWalkerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void home() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void addNewSite() throws Exception {
        final MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("siteUrl","https://test.url.com");
        param.add("test","https://test.url.com");
        ResultActions resultActions = this.mvc.perform(post("/add").params(param));
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}