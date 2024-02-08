package com.cwift.cwiftMarketplace_backend.repository;

import com.cwift.cwiftMarketplace_backend.model.CustomOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomOrderRepository extends JpaRepository<CustomOrder, Long> {

    List<CustomOrder> getAllByUserID( String userID);
    CustomOrder findByOrderID ( String orderID );
    String deleteByOrderID ( String orderID );
}
