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

CREATE TABLE IF NOT EXISTS site(
    site_url character varying NOT NULL,
    site_id int CONSTRAINT site_pkey PRIMARY KEY,
    page_html character varying,
    page_txt character varying,
    page_css character varying,
	page_js character varying,
	CONSTRAINT sites UNIQUE(site_url)
    );


CREATE TABLE IF NOT EXISTS sub_site(
    sub_site_id int CONSTRAINT sub_site_pkey PRIMARY KEY,
    site_url character varying NOT NULL,
    site_id int,
    page_html character varying,
    page_txt character varying,
    page_css character varying,
    page_js character varying,
    FOREIGN KEY (site_id) REFERENCES site(site_id),
    CONSTRAINT sub_sites UNIQUE(site_url)
);