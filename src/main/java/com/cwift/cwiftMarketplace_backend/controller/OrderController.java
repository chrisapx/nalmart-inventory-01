package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.service.ItemOrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ItemOrderServiceImpl itemOrderService;

    public OrderController ( ItemOrderServiceImpl itemOrderService ) {
        this.itemOrderService = itemOrderService;
    }

    @GetMapping("/status-list")
    public ResponseEntity<List<String>> orderStatusList(){
        return ResponseEntity.ok ( itemOrderService.getOrderStatusList ());
    }
}
