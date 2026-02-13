CREATE TABLE IF NOT EXISTS public.users
(
    id            int8         NOT NULL PRIMARY KEY,
    username      varchar(100) NOT NULL unique,
    full_name     varchar(100) NOT NULL,
    password_hash bytea        NOT NULL,
    created       timestamp(6) NOT NULL,
    updated      timestamp(6) NULL
);
