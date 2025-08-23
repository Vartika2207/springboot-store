CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    category_id   TINYINT NULL,
    `description` VARCHAR(255) NULL,
    price         DECIMAL(38, 2) NOT NULL,
    name          VARCHAR(255)   NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);