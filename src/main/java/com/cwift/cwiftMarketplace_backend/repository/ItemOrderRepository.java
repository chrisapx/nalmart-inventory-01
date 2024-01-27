package com.cwift.cwiftMarketplace_backend.repository;

import com.cwift.cwiftMarketplace_backend.model.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
    ItemOrder findByOrderID ( String orderID );
}
