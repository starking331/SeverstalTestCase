package com.severstal.delivery.repository;

import com.severstal.delivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByDeliveryDateBetween(Date startDate, Date endDate);
}
