--liquibase formatted sql

--changeset deliveryProject:1
CREATE TABLE Supplier (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

--changeset deliveryProject:2
CREATE TABLE Product (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         type VARCHAR(255) NOT NULL
);

--changeset deliveryProject:3
CREATE TABLE Price (
                       id BIGSERIAL PRIMARY KEY,
                       price DECIMAL(10, 2) NOT NULL,
                       start_date DATE NOT NULL,
                       end_date DATE NOT NULL,
                       supplier_id BIGINT NOT NULL,
                       product_id BIGINT NOT NULL,
                       FOREIGN KEY (supplier_id) REFERENCES Supplier(id),
                       FOREIGN KEY (product_id) REFERENCES Product(id)
);

--changeset deliveryProject:4
CREATE TABLE Delivery (
                          id BIGSERIAL PRIMARY KEY,
                          delivery_date DATE NOT NULL,
                          supplier_id BIGINT NOT NULL,
                          FOREIGN KEY (supplier_id) REFERENCES Supplier(id)
);

--changeset deliveryProject:5
CREATE TABLE delivery_detail (
                                 id BIGSERIAL PRIMARY KEY,
                                 quantity DECIMAL(10, 2) NOT NULL,
                                 delivery_id BIGINT NOT NULL,
                                 product_id BIGINT NOT NULL,
                                 price_id BIGINT NOT NULL,
                                 FOREIGN KEY (delivery_id) REFERENCES delivery(id),
                                 FOREIGN KEY (product_id) REFERENCES product(id),
                                 FOREIGN KEY (price_id) REFERENCES price(id)
);