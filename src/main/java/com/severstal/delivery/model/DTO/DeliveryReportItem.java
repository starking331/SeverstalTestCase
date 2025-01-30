package com.severstal.delivery.model.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryReportItem {
    private String supplierName;
    private String productName;
    private BigDecimal totalWeight;
    private BigDecimal totalCost;
}
