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

INSERT INTO OJT_OMS_ACT_JPA (act_id, act_nm, zip_cd, addr1, addr2, tax_no, create_dt, create_id)
VALUES ('거래처'||i, '병원이름'||i, '1000'||i, '서울특별시 마포구', '15-1', '12-1234-1234', '2024/04/08', '거래처'||i);

INSERT INTO OJT_OMS_OWNER
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_CATEGORY (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ITEM (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_ORDER (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_USER (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_CART (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

INSERT INTO OJT_OMS_CART_ITEM (컬럼명1, 컬럼명2 ...)
VALUES (i, 'user'+i, 20+i);

END LOOP;
END;




CREATE TABLE "OJT_OMS_OWNER" (
  "owner_id" VARCHAR2(50),
  "owner_nm" VARCHAR2(200),
  "ceo_nm" VARCHAR2(50),
  "owner_tel" VARCHAR2(40),
  "owner_fax" VARCHAR2(20),
  "create_dt" TIMESTAMP,
  "create_id" VARCHAR2(30),
  "edit_dt" TIMESTAMP,
  "edit_id" VARCHAR2(30)
);

CREATE TABLE "OJT_OMS_ACT" (
  "act_id" VARCHAR2(50),
  "act_nm" VARCHAR2(200),
  "zip_cd" VARCHAR2(6),
  "addr1" VARCHAR2(255),
  "addr2" VARCHAR2(255),
  "act_tel" VARCHAR2(50),
  "act_mng" VARCHAR2(50),
  "tax_no" VARCHAR2(20),
  "create_dt" TIMESTAMP,
  "create_id" VARCHAR2(30),
  "edit_dt" TIMESTAMP,
  "edit_id" VARCHAR2(30)
);

CREATE TABLE "OJT_OMS_CATEGORY" (
  "cate_id" VARCHAR2(50),
  "cate_nm" VARCHAR2(50)
);

CREATE TABLE "OJT_OMS_ITEM" (
  "item_id" VARCHAR2(50),
  "owner_id" VARCHAR2(50),
  "cate_id" VARCHAR2(50),
  "item_nm" VARCHAR2(200),
  "item_en_nm" VARCHAR2(200),
  "stock" NUMBER,
  "unit" VARCHAR2(10),
  "create_dt" TIMESTAMP,
  "create_id" VARCHAR2(30),
  "edit_dt" TIMESTAMP,
  "edit_id" VARCHAR2(30),
  CONSTRAINT "FK_OJT_OMS_ITEM.cate_id"
    FOREIGN KEY ("cate_id")
      REFERENCES "OJT_OMS_CATEGORY"("cate_id"),
  CONSTRAINT "FK_OJT_OMS_ITEM.owner_id"
    FOREIGN KEY ("owner_id")
      REFERENCES "OJT_OMS_OWNER"("owner_id")
);

CREATE TABLE "OJT_OMS_ORDER" (
  "seq" NUMBER,
  "owner_id" VARCHAR2(50),
  "act_id" VARCHAR2(50),
  "item_id" VARCHAR2(50),
  "quantity" NUMBER,
  "unit" VARCHAR2(10),
  "create_dt" TIMESTAMP,
  "create_id" VARCHAR2(30),
  "edit_dt" TIMESTAMP,
  "edit_id" VARCHAR2(30),
  CONSTRAINT "FK_OJT_OMS_ORDER.owner_id"
    FOREIGN KEY ("owner_id")
      REFERENCES "OJT_OMS_OWNER"("owner_id"),
  CONSTRAINT "FK_OJT_OMS_ORDER.act_id"
    FOREIGN KEY ("act_id")
      REFERENCES "OJT_OMS_ACT"("act_id"),
  CONSTRAINT "FK_OJT_OMS_ORDER.item_id"
    FOREIGN KEY ("item_id")
      REFERENCES "OJT_OMS_ITEM"("item_id")
);

CREATE TABLE "OJT_OMS_USER" (
  "user_id" VARCHAR2(30),
  "owner_id" VARCHAR2(50),
  "user_pwd" VARCHAR2(20),
  "user_nm" VARCHAR2(50),
  "user_role" VARCHAR2(20),
  "user_tel" VARCHAR2(40),
  "user_email" VARCHAR2(100),
  "user_use" CHAR,
  "create_dt" TIMESTAMP,
  "create_id" VARCHAR2(30),
  "edit_dt" TIMESTAMP,
  "edit_id" VARCHAR2(30),
  CONSTRAINT "FK_OJT_OMS_USER.owner_id"
    FOREIGN KEY ("owner_id")
      REFERENCES "OJT_OMS_OWNER"("owner_id")
);

CREATE TABLE "OJT_OMS_CART" (
  "cart_id" NUMBER,
  "user_id" VARCHAR2(50),
  CONSTRAINT "FK_OJT_OMS_CART.user_id"
    FOREIGN KEY ("user_id")
      REFERENCES "OJT_OMS_USER"("user_id")
);

CREATE TABLE "OJT_OMS_CART_ITEM" (
  "cart_item_id" NUMBER,
  "cart_id" NUMBER,
  "item_id" VARCHAR2(50),
  "quantity" NUMBER,
  CONSTRAINT "FK_OJT_OMS_CART_ITEM.cart_id"
    FOREIGN KEY ("cart_id")
      REFERENCES "OJT_OMS_CART"("cart_id"),
  CONSTRAINT "FK_OJT_OMS_CART_ITEM.item_id"
    FOREIGN KEY ("item_id")
      REFERENCES "OJT_OMS_ITEM"("item_id")
);
