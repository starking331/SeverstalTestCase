--changeset deliveryProject:6
INSERT INTO Supplier (name) VALUES ('Supplier 1');
INSERT INTO Supplier (name) VALUES ('Supplier 2');
INSERT INTO Supplier (name) VALUES ('Supplier 3');

--changeset deliveryProject:7
INSERT INTO Product (name, type) VALUES ('Green Pear', 'PEARS');
INSERT INTO Product (name, type) VALUES ('Yellow Pear', 'PEARS');
INSERT INTO Product (name, type) VALUES ('Red Apple', 'APPLES');
INSERT INTO Product (name, type) VALUES ('Green Apple', 'APPLES');

--changeset deliveryProject:8
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (10.00, '2023-01-01', '2023-12-31', 1, 1);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (12.00, '2023-01-01', '2023-12-31', 2, 1);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (11.00, '2023-01-01', '2023-12-31', 3, 1);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (13.00, '2023-01-01', '2023-12-31', 1, 2);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (14.00, '2023-01-01', '2023-12-31', 2, 2);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (15.00, '2023-01-01', '2023-12-31', 3, 2);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (8.00, '2023-01-01', '2023-12-31', 1, 3);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (9.00, '2023-01-01', '2023-12-31', 2, 3);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (10.50, '2023-01-01', '2023-12-31', 3, 3);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (7.00, '2023-01-01', '2023-12-31', 1, 4);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (8.50, '2023-01-01', '2023-12-31', 2, 4);
INSERT INTO Price (price, start_date, end_date, supplier_id, product_id) VALUES (9.50, '2023-01-01', '2023-12-31', 3, 4);

--changeset deliveryProject:9
INSERT INTO Delivery (delivery_date, supplier_id) VALUES ('2023-01-15', 1);
INSERT INTO Delivery (delivery_date, supplier_id) VALUES ('2023-02-15', 2);
INSERT INTO Delivery (delivery_date, supplier_id) VALUES ('2023-03-15', 3);

--changeset deliveryProject:10
INSERT INTO delivery_detail (quantity, delivery_id, product_id) VALUES (100, 1, 1);
INSERT INTO delivery_detail (quantity, delivery_id, product_id) VALUES (200, 2, 2);
INSERT INTO delivery_detail (quantity, delivery_id, product_id) VALUES (150, 3, 3);
INSERT INTO delivery_detail (quantity, delivery_id, product_id) VALUES (250, 1, 4);