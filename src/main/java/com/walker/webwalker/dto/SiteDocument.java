package com.walker.webwalker.dto;

import lombok.Builder;
import lombok.Data;

import org.jsoup.nodes.Element;

import javax.annotation.Resource;
import java.nio.charset.Charset;

@Data
@Builder
@Resource
public class SiteDocument {
    private Element head;
    private Element body;
    private Charset charset;
}
