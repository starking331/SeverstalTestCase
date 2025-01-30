package com.severstal.delivery.repository;

import com.severstal.delivery.model.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail, Long> {
    List<DeliveryDetail> findByDeliveryId(Long deliveryId);
}
