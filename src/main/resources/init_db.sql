CREATE TABLE BANK_ACCOUNTS (
                               uuid                CHAR(36) PRIMARY KEY NOT NULL,
                               account_number      LONG(19) NOT NULL,
                               owners_full_name    TEXT NOT NULL,
                               balance             FLOAT NOT NULL
);

CREATE TABLE CARDS (
                       id                 SERIAL,
                       card_number        LONG(12) NOT NULL,
                       owners_full_name   TEXT NOT NULL
);