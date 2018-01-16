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
    id character varying(32),
    page_html character varying,
    page_css character varying,
	page_js character varying
    );

ALTER TABLE ONLY site
    ADD CONSTRAINT site_pkey PRIMARY KEY (site_url);