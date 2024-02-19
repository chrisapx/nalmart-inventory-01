package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.Cart;
import com.cwift.cwiftMarketplace_backend.model.ItemOrder;

import java.util.List;

public interface CartService {

    Cart createCart ( Cart cart );
    Cart addToCart ( String cartID, ItemOrder itemOrder );
    Cart getCart ( String cartID );
    List<Cart> getAllCarts ();
    String deleteCart ( String cartID );
    Cart editCart ( String cartID, Cart cart );

}
