package com.walker.webwalker.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
public class Difference {
    @Id
    private Integer id;
    @NotNull
    private String diff;
    private Date comparedDate;
}
