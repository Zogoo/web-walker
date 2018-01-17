package com.walker.webwalker.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Site {
    @Autowired
    private DSLContext dsl;

}
