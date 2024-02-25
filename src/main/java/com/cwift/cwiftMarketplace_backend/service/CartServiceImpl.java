package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Cart;
import com.cwift.cwiftMarketplace_backend.model.ItemOrder;
import com.cwift.cwiftMarketplace_backend.repository.CartRepository;
import com.cwift.cwiftMarketplace_backend.repository.ItemRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final EmailSenderServiceimpl emailSenderServiceimpl;

    public CartServiceImpl ( CartRepository cartRepository, ItemRepository itemRepository, EmailSenderServiceimpl emailSenderServiceimpl ) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.emailSenderServiceimpl = emailSenderServiceimpl;
    }

    @Override
    public Cart createCart ( Cart cart ) {
        try{
            Cart cart1 = cartRepository.findByUserID(cart.getUserID ());

            if(cart1 == null){
                emailSenderServiceimpl.sendEmail ( cart.getUserEmail (), "Order Created Successfully", "Hello ,\n\n " +
                        "Your order has been created successfully with items \n" +
                        cart.getItemOrders ().stream ().map ( order -> itemRepository.findByItemID ( order.getItemID () ).getName ().concat ( " ( " +order.getQuantity () + " )" ) ).toList () +
                        "\n With total price " + cart.getTotalPrice () + "\n\n" +
                        "Thank you for trusting us with your needs"
                );
                return cartRepository.save ( cart );
            }else {
                emailSenderServiceimpl.sendEmail ( cart.getUserEmail (), "Order Created Successfully", "Hello ,\n\n " +
                        "Your order has been created successfully with items \n" +
                        cart.getItemOrders ().stream ().map ( order -> itemRepository.findByItemID ( order.getItemID () ).getName ().concat ( " ( " +order.getQuantity () + " )" ) ).toList () +
                        "\n With total price " + cart.getTotalPrice () + "\n\n" +
                        "Thank you for trusting us with your needs"
                );
                cart1.getItemOrders ().addAll ( cart.getItemOrders () );
                return cartRepository.save ( cart1 );
            }
        }
        catch ( Exception e ) {
            throw new RuntimeException ( e );
        }
    }

    @Override
    public Cart addToCart ( String cartID, ItemOrder itemOrder ) {
        try{
            Cart cart = cartRepository.findByCartID ( cartID );
            if(cart.getCreatedAt () != null){
                cart.getItemOrders ().add ( itemOrder );
            }
            return cartRepository.save ( cart );
        }
        catch ( Exception e ) {
            throw new RuntimeException ( e );
        }
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
