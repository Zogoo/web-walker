package com.walker.webwalker.dto;

import lombok.Data;

import lombok.NonNull;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Data
@Component
public class SiteDocument {
    @NonNull
    private Element head;
    @NonNull
    private Element body;
    @NonNull
    private Charset charset;
}
