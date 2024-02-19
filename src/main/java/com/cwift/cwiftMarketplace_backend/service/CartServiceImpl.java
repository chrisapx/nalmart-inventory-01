package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Cart;
import com.cwift.cwiftMarketplace_backend.repository.CartRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl ( CartRepository cartRepository ) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart ( Cart cart ) {
        return cartRepository.save ( cart );
    }

    @Override
    public Cart getCart ( String cartID ) {
        return cartRepository.findByCartID(cartID);
    }

    @Override
    public List<Cart> getAllCarts () {
        return cartRepository.findAll ();
    }

    @Override
    public String deleteCart ( String cartID ) {
        return cartRepository.deleteByCartID(cartID);
    }

    @Override
    public Cart editCart ( String cartID, Cart cart ) {
        return null;
    }
}
