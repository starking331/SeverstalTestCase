package com.severstal.delivery.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "product")
public class Product extends BaseEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Price> prices;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DeliveryDetail> deliveryDetails;
}
