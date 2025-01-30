package com.severstal.delivery.service;

import com.severstal.delivery.model.DTO.DeliveryResponse;
import com.severstal.delivery.model.Delivery;
import com.severstal.delivery.model.DeliveryDetail;
import com.severstal.delivery.repository.DeliveryDetailRepository;
import com.severstal.delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryDetailRepository deliveryDetailRepository;

    public DeliveryResponse saveDelivery(Delivery delivery, List<DeliveryDetail> details) {
        Delivery savedDelivery = deliveryRepository.save(delivery);
        for (DeliveryDetail detail : details) {
            detail.setDelivery(savedDelivery);
            deliveryDetailRepository.save(detail);
        }
        DeliveryResponse response = new DeliveryResponse();
        response.setId(savedDelivery.getId());
        response.setSupplierId(savedDelivery.getSupplier().getId());
        response.setDeliveryDate(savedDelivery.getDeliveryDate());

        return response;
    }
}
