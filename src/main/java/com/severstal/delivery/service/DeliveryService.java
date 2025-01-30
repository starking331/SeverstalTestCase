package com.severstal.delivery.service;

import com.severstal.delivery.model.DTO.DeliveryReportItem;
import com.severstal.delivery.model.DTO.DeliveryResponse;
import com.severstal.delivery.model.Delivery;
import com.severstal.delivery.model.DeliveryDetail;
import com.severstal.delivery.model.Price;
import com.severstal.delivery.repository.DeliveryDetailRepository;
import com.severstal.delivery.repository.DeliveryRepository;
import com.severstal.delivery.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryDetailRepository deliveryDetailRepository;
    private final PriceRepository priceRepository;

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

    public List<DeliveryReportItem> getDeliveryReport(Date startDate, Date endDate) {
        List<Delivery> deliveries = deliveryRepository.findByDeliveryDateBetween(startDate, endDate);

        return deliveries.stream()
                .flatMap(delivery -> delivery.getDeliveryDetails().stream()
                        .map(deliveryDetail -> {
                            DeliveryReportItem item = new DeliveryReportItem();
                            item.setSupplierName(delivery.getSupplier().getName());
                            item.setProductName(deliveryDetail.getProduct().getName());
                            item.setTotalWeight(deliveryDetail.getQuantity());

                            Price price = priceRepository.findByProductAndSupplierAndDate(deliveryDetail.getProduct(), delivery.getSupplier(), delivery.getDeliveryDate())
                                    .orElseThrow(() -> new RuntimeException("Price not found"));
                            item.setTotalCost(deliveryDetail.getQuantity().multiply(price.getPrice()));
                            return item;
                        })).collect(Collectors.toList());
    }
}
