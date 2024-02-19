package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.Cart;
import com.cwift.cwiftMarketplace_backend.model.ItemOrder;

import java.util.List;

public interface CartService {

    public Cart createCart( Cart cart);
    public Cart getCart(String cartID);
    public List<Cart> getAllCarts();
    public String deleteCart(String cartID);
    public Cart editCart(String cartID, Cart cart);

}
