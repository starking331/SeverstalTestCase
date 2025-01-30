--liquibase formatted sql

--changeset deliveryProject:1
INSERT INTO supplier (name) VALUES ('Supplier 1');
INSERT INTO supplier (name) VALUES ('Supplier 2');

INSERT INTO product (name, type) VALUES ('Apple', 'APPLES');
INSERT INTO product (name, type) VALUES ('Pear', 'PEARS');

INSERT INTO price (price, start_date, end_date, supplier_id, product_id) VALUES (10.00, '2023-01-01', '2023-12-31', 1, 1);
INSERT INTO price (price, start_date, end_date, supplier_id, product_id) VALUES (15.00, '2023-01-01', '2023-12-31', 2, 2);

INSERT INTO delivery (delivery_date, supplier_id) VALUES ('2023-01-15', 1);
INSERT INTO delivery (delivery_date, supplier_id) VALUES ('2023-02-15', 2);

INSERT INTO delivery_detail (quantity, delivery_id, product_id, price_id) VALUES (100, 1, 1, 1);
INSERT INTO delivery_detail (quantity, delivery_id, product_id, price_id) VALUES (200, 2, 2, 2);