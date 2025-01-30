package com.severstal.delivery.repository;

import com.severstal.delivery.model.Price;
import com.severstal.delivery.model.Product;
import com.severstal.delivery.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE p.product = :product AND p.supplier = :supplier AND p.startDate <= :date AND p.endDate >= :date")
    Optional<Price> findByProductAndSupplierAndDate(@Param("product") Product product, @Param("supplier") Supplier supplier, @Param("date") Date date);
}
