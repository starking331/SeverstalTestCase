package com.severstal.delivery.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Table(name = "price")
public class Price extends BaseEntity {
    private BigDecimal price;
    private Date startDate;
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
