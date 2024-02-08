package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.CustomOrder;
import com.cwift.cwiftMarketplace_backend.repository.CustomOrderRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.CustomOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomOrderServiceImpl implements CustomOrderService {

    private final CustomOrderRepository customOrderRepository;

    public CustomOrderServiceImpl ( CustomOrderRepository customOrderRepository ) {
        this.customOrderRepository = customOrderRepository;
    }

    @Override
    public CustomOrder createCustomOrder ( CustomOrder customerOrder ) {
        return customOrderRepository.save ( customerOrder );
    }

    @Override
    public CustomOrder getCustomOrder ( String orderID ) {
        return customOrderRepository.findByOrderID (orderID);
    }

    @Override
    public List<CustomOrder> getAllCustomOrders () {
        return customOrderRepository.findAll ();
    }

    @Override
    public List<CustomOrder> getAllCustomOrdersByUserID ( String userID ) {
        return customOrderRepository.getAllByUserID ( userID );
    }

    @Override
    public String deleteCustomOrder ( String orderID ) {
        return customOrderRepository.deleteByOrderID ( orderID );
    }

    @Override
    public CustomOrder editCustomOrder ( String orderID, CustomOrder customerOrder ) {
        return null;
    }
}
