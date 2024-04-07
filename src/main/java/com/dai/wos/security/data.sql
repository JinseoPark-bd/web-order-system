DROP TABLE IF EXISTS OJT_OMS_ACT;
DROP TABLE IF EXISTS OJT_OMS_CART;
DROP TABLE IF EXISTS OJT_OMS_CART_ITEM;
DROP TABLE IF EXISTS OJT_OMS_CATEGORY;
DROP TABLE IF EXISTS OJT_OMS_ITEM;
DROP TABLE IF EXISTS OJT_OMS_ORDER;
DROP TABLE IF EXISTS OJT_OMS_ORDER_ITEM;
DROP TABLE IF EXISTS OJT_OMS_OWNER;
DROP TABLE IF EXISTS OJT_OMS_USER;

CREATE TABLE OJT_OMS_ACT
(
    act_id      VARCHAR2(50)     NOT NULL,
    act_nm      VARCHAR2(200)    NOT NULL,
    zip_cd      VARCHAR2(6)      NOT NULL,
    addr1       VARCHAR2         NOT NULL,
    addr2       VARCHAR2,
    act_tel     VARCHAR2(50),
    act_mng     VARCHAR2(50),
    tax_no      VARCHAR2(20)     NOT NULL,
    create_dt   TIMESTAMP        NOT NULL,
    create_id   VARCHAR2(30)     NOT NULL,
    edit_dt     TIMESTAMP,
    edit_id     VARCHAR2(30),
    PRIMARY KEY (act_id)
);

CREATE TABLE OJT_OMS_CART
(
    cart_id      NUMBER         NOT NULL AUTO_INCREMENT,
    user_id      VARCHAR2(30)   NOT NULL,
    PRIMARY KEY (cart_id)
);

CREATE TABLE OJT_OMS_CART_ITEM
(
    cart_item_id    NUMBER        NOT NULL AUTO_INCREMENT,
    cart_id         NUMBER        NOT NULL,
    item_id         VARCHAR2(50)  NOT NULL,
    quantity        NUMBER,
    PRIMARY KEY (cart_item_id)
);


CREATE TABLE OJT_OMS_CATEGORY
(
    cate_id      VARCHAR2(50)    NOT NULL,
    cate_nm      VARCHAR2(50)    NOT NULL,
    PRIMARY KEY (cate_id)
);

CREATE TABLE OJT_OMS_ORDER
(
    seq           NUMBER            NOT NULL AUTO_INCREMENT,
    owner_id      VARCHAR2(50)      NOT NULL,
    act_id        VARCHAR2(50)      NOT NULL,
    item_id       VARCHAR2(50)      NOT NULL,
    quantity      NUMBER            NOT NULL,
    unit          VARCHAR2(10)      NOT NULL,
    create_dt     TIMESTAMP         NOT NULL,
    create_id     VARCHAR2(30)      NOT NULL,
    edit_dt       TIMESTAMP,
    edit_id       VARCHAR2(30),
    PRIMARY KEY (seq)
);

CREATE TABLE OJT_OMS_ITEM
(
    item_id       VARCHAR2(50)      NOT NULL,
    owner_id      VARCHAR2(50)      NOT NULL,
    cate_id       VARCHAR2(50)      NOT NULL,
    item_nm       VARCHAR2(200)     NOT NULL,
    item_en_nm    VARCHAR2(200),
    stock         NUMBER            NOT NULL,
    unit          VARCHAR2(10)      NOT NULL,
    create_dt     TIMESTAMP         NOT NULL,
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
    owner_id    VARCHAR2(20)    NOT NULL,
    user_pwd    VARCHAR2(20)    NOT NULL,
    user_nm     VARCHAR2(50)    NOT NULL,
    user_role   VARCHAR2(20)    NOT NULL,
    user_tel    VARCHAR2(40),
    user_email  VARCHAR2(100),
    user_use    CHAR            NOT NULL,
    create_dt   TIMESTAMP       NOT NULL,
    create_id   VARCHAR2(30)    NOT NULL,
    edit_dt     TIMESTAMP,
    edit_id     VARCHAR2(30),
    PRIMARY KEY (user_id)
);

BEGIN
FOR i IN 1..20 LOOP

INSERT INTO OJT_OMS_ACT (act_id, act_nm, zip_cd, addr1, addr2, create_dt, create_id)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_CART (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_CART_ITEM (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_CATEGORY (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ORDER (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ITEM (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_OWNER (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_USER (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

END LOOP;
END;