package com.severstal.delivery.model.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryDetailRequest {
    private BigDecimal quantity;
    private Long productId;
}
