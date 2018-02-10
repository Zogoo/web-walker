/*
 * This file is generated by jOOQ.
*/
package com.walker.webwalker.dao;


import com.walker.webwalker.dao.tables.Content;
import com.walker.webwalker.dao.tables.Difference;
import com.walker.webwalker.dao.tables.Page;
import com.walker.webwalker.dao.tables.SchemaVersion;
import com.walker.webwalker.dao.tables.Site;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.content</code>.
     */
    public static final Content CONTENT = com.walker.webwalker.dao.tables.Content.CONTENT;

    /**
     * The table <code>public.difference</code>.
     */
    public static final Difference DIFFERENCE = com.walker.webwalker.dao.tables.Difference.DIFFERENCE;

    /**
     * The table <code>public.page</code>.
     */
    public static final Page PAGE = com.walker.webwalker.dao.tables.Page.PAGE;

    /**
     * The table <code>public.schema_version</code>.
     */
    public static final SchemaVersion SCHEMA_VERSION = com.walker.webwalker.dao.tables.SchemaVersion.SCHEMA_VERSION;

    /**
     * The table <code>public.site</code>.
     */
    public static final Site SITE = com.walker.webwalker.dao.tables.Site.SITE;
}
