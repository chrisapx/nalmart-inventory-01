package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.ItemOrder;

import java.util.List;

public interface ItemOrderService {

    public ItemOrder createItemOrder( ItemOrder itemOrder);
    public ItemOrder getItemOrder(String orderID);
    public List<ItemOrder> getAllItemOrders();
    public List<ItemOrder> getAllItemOrderByUserID(String userID);
    public String deleteItemOrder(String orderID);
    public ItemOrder editItemOrder(String orderID, ItemOrder itemOrder);

    public List<String> getOrderStatusList ();
}
