CREATE TABLE books (
       no                   int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
       title                varchar(255) NULL,
       isbn                 CHAR(13) NULL,
       author               varchar(200) NULL,
       publisher            varchar(200) NULL,
       pdate                CHAR(8) NULL,
       edition              smallint NULL,
       status               ENUM('PRIVATE','PUBLIC','HOLD') NOT NULL DEFAULT 'PRIVATE',
       link                 varchar(255) NULL,
       registdate           CHAR(14) NULL,
       rpoint               int(11) NULL,
       members_no           int(11) NULL,
       category1_no         int(11) NULL,
       category2_no         int(11) NULL
);


CREATE TABLE category1 (
       no                   int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
       name                 varchar(100) NULL
);

CREATE TABLE category2 (
       no                   int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
       name                 varchar(100) NULL,
       category1_no         int(11) NULL
);

CREATE TABLE history (
       no                   int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
       wdate                CHAR(14) NULL,
       members_no           int(11) NULL,
       books_no             int(11) NULL
);

CREATE TABLE members (
       no                   int(11) NOT NULL  AUTO_INCREMENT PRIMARY KEY,
       email                varchar(200) NULL,
       pw                   varchar(30) NULL,
       name                 varchar(50) NULL,
       tel                  CHAR(14) NULL,
       sido                 varchar(4) NULL,
       gugun                varchar(15) NULL,
       dong                 varchar(52) NULL,
       registdate           CHAR(14) NULL,
       authdate             CHAR(14) NULL,
       sticker              int(11) NULL
);

CREATE TABLE orders (
       no                   int(11) NOT NULL  AUTO_INCREMENT PRIMARY KEY,
       orders_date          CHAR(14) NULL,
       status               ENUM('DEMAND','DENY','CANCEL') NOT NULL DEFAULT 'DEMAND',
       members_no           int(11) NULL,
       books_no             int(11) NULL
);

CREATE TABLE zip (
       seq                  int(5) NOT NULL  AUTO_INCREMENT PRIMARY KEY,
       sido                 varchar(4) NULL,
       gugun                varchar(15) NULL,
       dong                 varchar(52) NULL,
       bunji                varchar(17) NULL,
       zipcode              CHAR(7) NULL
);
