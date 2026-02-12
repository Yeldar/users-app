CREATE TABLE IF NOT EXISTS public.users
(
    id            int8         NOT NULL PRIMARY KEY,
    username      varchar(100) NOT NULL unique,
    full_name     varchar(100) NOT NULL,
    password_hash bytea        NOT NULL,
    is_active     bool         NOT NULL default true,
    created       timestamp(6) NOT NULL,
    modified      timestamp(6) NULL
);

CREATE SEQUENCE public.users_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;