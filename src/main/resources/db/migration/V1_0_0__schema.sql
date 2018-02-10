--
-- PostgreSQL database dump
--
SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS site(
    id SERIAL PRIMARY KEY,
    site_url character varying NOT NULL,
    confirmed_at timestamptz,
    created_at timestamp NOT NULL DEFAULT NOW(),
    updated_at timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT sites UNIQUE(site_url)
);

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON site
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TABLE IF NOT EXISTS page(
    id SERIAL NOT NULL PRIMARY KEY,
    page_url character varying NOT NULL,
    site_id int,
    has_diff boolean DEFAULT false,
    FOREIGN KEY (site_id) REFERENCES site(id) ON UPDATE NO ACTION ON DELETE CASCADE,
    created_at timestamp NOT NULL DEFAULT NOW(),
    updated_at timestamp NOT NULL DEFAULT NOW(),
    CONSTRAINT sub_sites UNIQUE(page_url)
);

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON page
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TABLE IF NOT EXISTS content(
    id SERIAL NOT NULL PRIMARY KEY,
    base_content boolean NOT NULL,
    page_html character varying NOT NULL,
    page_txt character varying NOT NULL,
    page_css character varying,
    page_js character varying,
    page_id int,
    new_content_id int,
    created_at timestamp NOT NULL DEFAULT NOW(),
    updated_at timestamp NOT NULL DEFAULT NOW(),
    FOREIGN KEY (page_id) REFERENCES page(id) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (new_content_id) REFERENCES content(id) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON content
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TABLE IF NOT EXISTS difference(
    id SERIAL NOT NULL PRIMARY KEY,
    diff character varying NOT NULL,
    content_id int,
    compared_date timestamptz NOT NULL,
    created_at timestamp NOT NULL DEFAULT NOW(),
    updated_at timestamp NOT NULL DEFAULT NOW(),
    FOREIGN KEY (content_id) REFERENCES content(id) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON difference
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();


