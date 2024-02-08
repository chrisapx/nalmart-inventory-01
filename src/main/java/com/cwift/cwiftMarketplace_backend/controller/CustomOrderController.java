package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.model.CustomOrder;
import com.cwift.cwiftMarketplace_backend.service.CustomOrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custom-orders")
public class CustomOrderController {

    private final CustomOrderServiceImpl customOrderService;

    public CustomOrderController ( CustomOrderServiceImpl customOrderService ) {
        this.customOrderService = customOrderService;
    }

    @PostMapping
    public ResponseEntity<CustomOrder> createCustomOrder ( @RequestBody CustomOrder customerOrder ) {
        return ResponseEntity.ok (customOrderService.createCustomOrder ( customerOrder ));
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<CustomOrder> getCustomOrder ( @PathVariable String orderID ) {
        return ResponseEntity.ok (customOrderService.getCustomOrder ( orderID ));
    }

    @GetMapping
    public ResponseEntity<List<CustomOrder>> getAllCustomOrders () {
        return ResponseEntity.ok (customOrderService.getAllCustomOrders ());
    }

    @GetMapping("/{userID}/user")
    public ResponseEntity<List<CustomOrder>> getAllCustomOrdersByUserID ( @PathVariable String userID ) {
        return ResponseEntity.ok (customOrderService.getAllCustomOrdersByUserID ( userID ));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomOrder ( @RequestParam String orderID ) {
        return ResponseEntity.ok (customOrderService.deleteCustomOrder ( orderID ));
    }
}
