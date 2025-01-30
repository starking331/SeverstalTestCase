package com.severstal.delivery.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "delivery_detail")
public class DeliveryDetail extends BaseEntity {
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;
}
