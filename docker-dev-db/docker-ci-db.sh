#!/usr/bin/env bash
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE web_walker;

    CREATE ROLE walker WITH LOGIN PASSWORD 'walker';

    GRANT ALL ON DATABASE web_walker TO walker;
    GRANT ALL ON ALL TABLES IN SCHEMA public to walker;
EOSQL