package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.ItemOrder;
import com.cwift.cwiftMarketplace_backend.model.OrderStatus;
import com.cwift.cwiftMarketplace_backend.repository.ItemOrderRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.ItemOrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;

    public ItemOrderServiceImpl ( ItemOrderRepository itemOrderRepository ) {
        this.itemOrderRepository = itemOrderRepository;
    }

    @Override
    public ItemOrder createItemOrder ( ItemOrder itemOrder ) {
        return itemOrderRepository.save ( itemOrder );
    }

    @Override
    public ItemOrder getItemOrder ( String orderID ) {
        return itemOrderRepository.findByOrderID(orderID);
    }

    @Override
    public List<ItemOrder> getAllItemOrders () {
        return itemOrderRepository.findAll ();
    }

    @Override
    public List<ItemOrder> getAllItemOrderByUserID ( String userID ) {
        return null;
    }

    @Override
    public String deleteItemOrder ( String orderID ) {
        return null;
    }

    @Override
    public ItemOrder editItemOrder ( String orderID, ItemOrder itemOrder ) {
        return null;
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public List<String> getOrderStatusList () {
        return Arrays.stream( OrderStatus.values () ).map ( Enum::name ).collect( Collectors.toList());
    }
}
