package com.severstal.delivery.model.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DeliveryRequest {
    private Long supplierId;
    private Date deliveryDate;
    private List<DeliveryDetailRequest> details;
}
