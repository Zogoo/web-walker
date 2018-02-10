package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

@Data
@Builder
public class Site {
    @Id
    private Integer id;
    @NotNull
    private String siteUrl;
    private Date confirmedAt;
}
