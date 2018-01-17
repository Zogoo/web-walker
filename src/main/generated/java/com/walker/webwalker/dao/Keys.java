/*
 * This file is generated by jOOQ.
*/
package com.walker.webwalker.dao;


import com.walker.webwalker.dao.tables.SchemaVersion;
import com.walker.webwalker.dao.tables.Site;
import com.walker.webwalker.dao.tables.records.SchemaVersionRecord;
import com.walker.webwalker.dao.tables.records.SiteRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<SchemaVersionRecord> SCHEMA_VERSION_PK = UniqueKeys0.SCHEMA_VERSION_PK;
    public static final UniqueKey<SiteRecord> SITE_PKEY = UniqueKeys0.SITE_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<SchemaVersionRecord> SCHEMA_VERSION_PK = createUniqueKey(SchemaVersion.SCHEMA_VERSION, "schema_version_pk", SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK);
        public static final UniqueKey<SiteRecord> SITE_PKEY = createUniqueKey(Site.SITE, "site_pkey", Site.SITE.SITE_URL);
    }
}