package com.severstal.delivery.controller;

import com.severstal.delivery.model.DTO.DeliveryReportItem;
import com.severstal.delivery.model.DTO.DeliveryResponse;
import com.severstal.delivery.model.Delivery;
import com.severstal.delivery.model.DeliveryDetail;
import com.severstal.delivery.model.DTO.DeliveryRequest;
import com.severstal.delivery.model.Supplier;
import com.severstal.delivery.repository.ProductRepository;
import com.severstal.delivery.repository.SupplierRepository;
import com.severstal.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    @PostMapping
    public DeliveryResponse createDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        Delivery delivery = new Delivery();
        Supplier supplier = supplierRepository.findById(deliveryRequest.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        delivery.setSupplier(supplier);
        delivery.setDeliveryDate(deliveryRequest.getDeliveryDate());

        List<DeliveryDetail> details = deliveryRequest.getDetails().stream()
                .map(deliveryDetail -> {
                    DeliveryDetail detail = new DeliveryDetail();
                    detail.setQuantity(deliveryDetail.getQuantity());
                    detail.setProduct(productRepository.findById(deliveryDetail.getProductId())
                            .orElseThrow(() -> new RuntimeException("ProductNotFound")));
                    return detail;
                })
                .toList();

        return deliveryService.saveDelivery(delivery, details);
    }

    @GetMapping("/report")
    public List<DeliveryReportItem> getDeliveryReport(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return deliveryService.getDeliveryReport(startDate, endDate);
    }
}
