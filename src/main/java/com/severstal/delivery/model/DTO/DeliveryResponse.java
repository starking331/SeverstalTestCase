package com.severstal.delivery.model.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class DeliveryResponse {
    private Long id;
    private Long supplierId;
    private Date deliveryDate;
}
