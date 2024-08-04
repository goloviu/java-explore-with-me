DROP TABLE IF EXISTS hits CASCADE;

CREATE TABLE IF NOT EXISTS hits (
    id      BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    app     varchar(100) NOT NULL,
    uri     varchar(100) NOT NULL,
    ip      varchar(100) NOT NULL,
    request_date      timestamp NOT NULL
);