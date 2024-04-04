DROP TABLE IF EXISTS OJT_OMS_ACT;
DROP TABLE IF EXISTS OJT_OMS_CART;
DROP TABLE IF EXISTS OJT_OMS_CATEGORY;
DROP TABLE IF EXISTS OJT_OMS_ITEM;
DROP TABLE IF EXISTS OJT_OMS_ORDER;
DROP TABLE IF EXISTS OJT_OMS_ORDER_ITEM;
DROP TABLE IF EXISTS OJT_OMS_OWNER;
DROP TABLE IF EXISTS OJT_OMS_USER;

CREATE TABLE OJT_OMS_ACT
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20) NOT NULL,
    img_url VARCHAR(255),
    price   INT         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE OJT_OMS_CART
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20) NOT NULL,
    img_url VARCHAR(255),
    price   INT         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE OJT_OMS_CATEGORY
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20) NOT NULL,
    img_url VARCHAR(255),
    price   INT         NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE OJT_OMS_ORDER_ITEM
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20) NOT NULL,
    img_url VARCHAR(255),
    price   INT         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE OJT_OMS_ORDER
(
    item_id       VARCHAR2(50)      NOT NULL,
        item_nm       VARCHAR2(200)     NOT NULL,
        owner_id      VARCHAR2(50)      NOT NULL,
        cate_id       VARCHAR2(50)      NOT NULL,
        item_count    INT               NOT NULL,
        create_id     VARCHAR2(30)      NOT NULL,
        edit_dt       TIMESTAMP,
        edit_id       VARCHAR2(30),
        PRIMARY KEY (item_id)
);

CREATE TABLE OJT_OMS_ITEM
(
    item_id       VARCHAR2(50)      NOT NULL,
    item_nm       VARCHAR2(200)     NOT NULL,
    owner_id      VARCHAR2(50)      NOT NULL,
    cate_id       VARCHAR2(50)      NOT NULL,
    item_count    INT               NOT NULL,
    create_id     VARCHAR2(30)      NOT NULL,
    edit_dt       TIMESTAMP,
    edit_id       VARCHAR2(30),
    PRIMARY KEY (item_id)
);

CREATE TABLE OJT_OMS_OWNER
(
    owner_id      VARCHAR2(50)      NOT NULL AUTO_INCREMENT,
    owner_nm      VARCHAR2(200)     NOT NULL,
    ceo_nm        VARCHAR2(50),
    owner_tel     VARCHAR2(40),
    owner_fax     VARCHAR2(20),
    create_dt     TIMESTAMP         NOT NULL,
    create_id     VARCHAR2(30)      NOT NULL,
    edit_dt       TIMESTAMP,
    edit_id       VARCHAR2(30),
    PRIMARY KEY (owner_id)
);

CREATE TABLE OJT_OMS_USER
(
    user_id     VARCHAR2(30)    NOT NULL,
    user_pwd    VARCHAR2(20)    NOT NULL,
    user_nm     VARCHAR2(40)    NOT NULL,
    user_role   VARCHAR2(20)    NOT NULL,
    user_tel    VARCHAR2(40)    NOT NULL,
    user_email  VARCHAR2(100)   NOT NULL,
    user_use    CHAR            NOT NULL,
    owner_id    VARCHAR2(20)    NOT NULL,
    create_dt   TIMESTAMP       NOT NULL,
    create_id   VARCHAR2(30)    NOT NULL,
    edit_dt     TIMESTAMP,
    edit_id     VARCHAR2(30),
    PRIMARY KEY (user_id)
);

BEGIN
FOR i IN 1..100 LOOP

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);


END LOOP;
END;
