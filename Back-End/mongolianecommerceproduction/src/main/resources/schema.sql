DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
    email  varchar(30) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    reg_date DATE,
    PRIMARY KEY (email)
);

CREATE TABLE new (
    id  INTEGER NOT NULL,
    article VARCHAR(100) NOT NULL,
    publish_date DATE,
    img_url VARCHAR(120) NOT NULL,
    type VARCHAR(120) NOT NULL,
    detail VARCHAR(5000) NOT NULL,
    PRIMARY KEY (id)
);
