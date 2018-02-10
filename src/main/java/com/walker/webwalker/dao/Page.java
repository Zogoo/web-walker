package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.net.MalformedURLException;
import java.net.URL;

@Data
@Builder
public class Page {

    @Id
    private Integer id;
    @NotNull
    private String pageUrl;
    private Integer siteId;
    private Boolean hasDiff;
}
