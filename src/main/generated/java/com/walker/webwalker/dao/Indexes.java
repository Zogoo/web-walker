/*
 * This file is generated by jOOQ.
*/
package com.walker.webwalker.dao;


import com.walker.webwalker.dao.tables.SchemaVersion;
import com.walker.webwalker.dao.tables.Site;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SCHEMA_VERSION_PK = Indexes0.SCHEMA_VERSION_PK;
    public static final Index SCHEMA_VERSION_S_IDX = Indexes0.SCHEMA_VERSION_S_IDX;
    public static final Index SITE_PKEY = Indexes0.SITE_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index SCHEMA_VERSION_PK = createIndex("schema_version_pk", SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK }, true);
        public static Index SCHEMA_VERSION_S_IDX = createIndex("schema_version_s_idx", SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.SUCCESS }, false);
        public static Index SITE_PKEY = createIndex("site_pkey", Site.SITE, new OrderField[] { Site.SITE.SITE_URL }, true);
    }
}