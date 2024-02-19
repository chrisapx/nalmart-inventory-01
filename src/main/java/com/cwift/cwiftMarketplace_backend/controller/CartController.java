package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.model.Cart;
import com.cwift.cwiftMarketplace_backend.service.CartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@CrossOrigin(originPatterns = "*")
public class CartController {

    private final CartServiceImpl cartService;

    public CartController ( CartServiceImpl cartService ) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart ( @RequestBody Cart cart ) {
        return ResponseEntity.ok (cartService.createCart ( cart ));
    }

    @GetMapping("/cartID")
    public ResponseEntity<Cart> getCart ( @RequestParam String cartID ) {
        return ResponseEntity.ok (cartService.getCart ( cartID ));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts () {
        return ResponseEntity.ok (cartService.getAllCarts ());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCart ( @RequestParam String cartID ) {
        return ResponseEntity.ok (cartService.deleteCart ( cartID ));
    }

    public ResponseEntity<Cart> editCart ( String cartID, Cart cart ) {
        return null;
    }
}
