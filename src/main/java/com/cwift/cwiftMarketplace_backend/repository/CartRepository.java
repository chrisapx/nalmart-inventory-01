package com.cwift.cwiftMarketplace_backend.repository;

import com.cwift.cwiftMarketplace_backend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByCartID ( String cartID );
    String deleteByCartID ( String cartID );
}
