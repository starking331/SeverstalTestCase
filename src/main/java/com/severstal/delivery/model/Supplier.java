package com.severstal.delivery.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Price> prices;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Delivery> deliveries;
}
