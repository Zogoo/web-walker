package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.net.MalformedURLException;
import java.net.URL;

@Data
@Builder
public class Content {
    @Id
    private Integer id;
    @NotNull
    private Boolean baseContent;
    @NotNull
    private String pageHtml;
    @NotNull
    private String pageTxt;
    private String pageCss;
    private String pageJs;
    private Integer pageId;
    private Integer newContentId;
}
