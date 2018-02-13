/*
 * This file is generated by jOOQ.
*/
package com.walker.webwalker.dao.tables;


import com.walker.webwalker.dao.Indexes;
import com.walker.webwalker.dao.Keys;
import com.walker.webwalker.dao.Public;
import com.walker.webwalker.dao.tables.records.ContentRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Content extends TableImpl<ContentRecord> {

    private static final long serialVersionUID = 1695561801;

    /**
     * The reference instance of <code>public.content</code>
     */
    public static final Content CONTENT = new Content();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ContentRecord> getRecordType() {
        return ContentRecord.class;
    }

    /**
     * The column <code>public.content.id</code>.
     */
    public final TableField<ContentRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('content_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.content.base_content</code>.
     */
    public final TableField<ContentRecord, Boolean> BASE_CONTENT = createField("base_content", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.content.page_html</code>.
     */
    public final TableField<ContentRecord, String> PAGE_HTML = createField("page_html", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.content.page_txt</code>.
     */
    public final TableField<ContentRecord, String> PAGE_TXT = createField("page_txt", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.content.page_css</code>.
     */
    public final TableField<ContentRecord, String> PAGE_CSS = createField("page_css", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.content.page_js</code>.
     */
    public final TableField<ContentRecord, String> PAGE_JS = createField("page_js", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.content.page_id</code>.
     */
    public final TableField<ContentRecord, Integer> PAGE_ID = createField("page_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.content.new_content_id</code>.
     */
    public final TableField<ContentRecord, Integer> NEW_CONTENT_ID = createField("new_content_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.content.created_at</code>.
     */
    public final TableField<ContentRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.content.updated_at</code>.
     */
    public final TableField<ContentRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.content</code> table reference
     */
    public Content() {
        this(DSL.name("content"), null);
    }

    /**
     * Create an aliased <code>public.content</code> table reference
     */
    public Content(String alias) {
        this(DSL.name(alias), CONTENT);
    }

    /**
     * Create an aliased <code>public.content</code> table reference
     */
    public Content(Name alias) {
        this(alias, CONTENT);
    }

    private Content(Name alias, Table<ContentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Content(Name alias, Table<ContentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CONTENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ContentRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CONTENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ContentRecord> getPrimaryKey() {
        return Keys.CONTENT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ContentRecord>> getKeys() {
        return Arrays.<UniqueKey<ContentRecord>>asList(Keys.CONTENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ContentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ContentRecord, ?>>asList(Keys.CONTENT__CONTENT_PAGE_ID_FKEY, Keys.CONTENT__CONTENT_NEW_CONTENT_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content as(String alias) {
        return new Content(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content as(Name alias) {
        return new Content(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Content rename(String name) {
        return new Content(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Content rename(Name name) {
        return new Content(name, null);
    }
}