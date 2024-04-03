CREATE DATABASE IF NOT EXISTS jpa_ecommerce;

USE jpa_ecommerce;

CREATE TABLE IF NOT EXISTS category (
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS filter (
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    is_range bit(1),
    name varchar(255),
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS filter_category (
    filter_id bigint(20) NOT NULL,
    category_id bigint(20) NOT NULL,
    PRIMARY KEY (filter_id, category_id),
    FOREIGN KEY(`filter_id`) REFERENCES `filter`(`id`),
    FOREIGN KEY(`category_id`) REFERENCES `category`(`id`)
);

CREATE TABLE IF NOT EXISTS filter_value (
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    value varchar(255),
    filter_id bigint(20),
    UNIQUE (id),
    FOREIGN KEY(`filter_id`) REFERENCES `filter`(`id`)
);

CREATE TABLE IF NOT EXISTS product (
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price decimal(38,2) NOT NULL,
    price_in_usd bit(1),
    category_id bigint(20),
    UNIQUE (id),
    FOREIGN KEY(`category_id`) REFERENCES `category`(`id`)
);

    -- PRIMARY KEY (product_id, filter_value_id)
CREATE TABLE IF NOT EXISTS product_filter_value (
    product_id bigint(20),
    filter_value_id bigint(20),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    FOREIGN KEY(`filter_value_id`) REFERENCES `filter_value`(`id`)
);

-- jpaecommerceserver-mysql-ec-1  | 2024-04-02T01:32:47.945997Z 6 [ERROR] [MY-000061] [Server] 1060  Duplicate column name '1'.

INSERT INTO category (name) 
SELECT * FROM (SELECT 'vehicle') AS tmp
WHERE NOT EXISTS (SELECT name FROM category WHERE name = 'vehicle');


INSERT INTO filter (is_range, name) 
SELECT * FROM (SELECT false, 'model') AS tmp
WHERE NOT EXISTS (SELECT name FROM filter WHERE name = 'model');

INSERT INTO filter (is_range, name) 
SELECT * FROM (SELECT false, 'year') AS tmp
WHERE NOT EXISTS (SELECT name FROM filter WHERE name = 'year');


-- INSERT INTO filter_category (filter_id, category_id)
-- SELECT * FROM (SELECT 1, 1) AS tmp 
-- WHERE NOT EXISTS (SELECT filter_id, category_id FROM filter_category WHERE filter_id = 1 AND category_id = 1);
-- INSERT INTO filter_category (filter_id, category_id) VALUES (1, 1)
-- ON DUPLICATE KEY UPDATE filter_id = 1 AND category_id = 1;
REPLACE INTO filter_category (filter_id, category_id) VALUES (1, 1);

-- INSERT INTO filter_category (filter_id, category_id) 
-- SELECT * FROM (SELECT 2, 1) AS tmp 
-- WHERE NOT EXISTS (SELECT filter_id, category_id FROM filter_category WHERE filter_id = 2 AND category_id = 1);
-- INSERT INTO filter_category (filter_id, category_id) VALUES (2, 1)
-- ON DUPLICATE KEY UPDATE filter_id = 2 AND category_id = 1;
REPLACE INTO filter_category (filter_id, category_id) VALUES (2, 1);


INSERT INTO product (name, price, price_in_usd, category_id) 
SELECT * FROM (SELECT 'Chevrolet Tracker', 18890900, false, 1) AS tmp
WHERE NOT EXISTS (SELECT name FROM product WHERE name = 'Chevrolet Tracker');


INSERT INTO filter_value (value, filter_id) 
SELECT * FROM (SELECT 'Tracker', 1) AS tmp
WHERE NOT EXISTS (SELECT value FROM filter_value WHERE value = 'Tracker');

INSERT INTO filter_value (value, filter_id) 
SELECT * FROM (SELECT '2019', 2) AS tmp
WHERE NOT EXISTS (SELECT value FROM filter_value WHERE value = '2019');


-- INSERT INTO product_filter_value (product_id, filter_value_id)
-- SELECT * FROM (SELECT 1, 1) AS tmp 
-- WHERE NOT EXISTS (SELECT product_id, filter_value_id FROM product_filter_value WHERE product_id = 1 AND filter_value_id = 1);
INSERT INTO product_filter_value (product_id, filter_value_id) VALUES (1, 1)
ON DUPLICATE KEY UPDATE product_id = 1 AND filter_value_id = 1;

-- INSERT INTO product_filter_value (product_id, filter_value_id) 
-- SELECT * FROM (SELECT 1, 2) AS tmp 
-- WHERE NOT EXISTS (SELECT product_id, filter_value_id FROM product_filter_value WHERE product_id = 1 AND filter_value_id = 2);
INSERT INTO product_filter_value (product_id, filter_value_id) VALUES (1, 2)
ON DUPLICATE KEY UPDATE product_id = 1 AND filter_value_id = 2;

/*
    INSERT INTO category (id, name) VALUES (1, 'vehicle')
        ON DUPLICATE KEY UPDATE id = 1;

    INSERT INTO filter (id, is_range, name) VALUES (1, false, 'model')
        ON DUPLICATE KEY UPDATE id = 1;
    INSERT INTO filter (id, is_range, name) VALUES (2, false, 'year')
        ON DUPLICATE KEY UPDATE id = 2;

    INSERT INTO filter_category (filter_id,category_id) VALUES (1, 1);
    INSERT INTO filter_category (filter_id,category_id) VALUES (2, 1);

    INSERT INTO product (id, name, price, price_in_usd, category_id) 
        VALUES (1,'Chevrolet Tracker', 18890900, false, 1)
        ON DUPLICATE KEY UPDATE id = 1;

    INSERT INTO filter_value (id, value, filter_id) VALUES (1, 'Tracker', 1)
        ON DUPLICATE KEY UPDATE id = 1;
    INSERT INTO filter_value (id, value, filter_id) VALUES (2, '2019', 2)
        ON DUPLICATE KEY UPDATE id = 2;

    INSERT INTO product_filter_value (product_id, filter_value_id) VALUES (1, 1);
    INSERT INTO product_filter_value (product_id, filter_value_id) VALUES (1, 2);
*/