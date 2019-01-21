DROP TABLE IF EXISTS post_new;
CREATE TABLE post_new (
    id  bigint(25) NOT NULL,
    article VARCHAR(100) NOT NULL,
    published_date DATE,
    img_url VARCHAR(500) NOT NULL,
    category VARCHAR(120) NOT NULL,
    detail VARCHAR(5000) NOT NULL,
    PRIMARY KEY (id)
);

