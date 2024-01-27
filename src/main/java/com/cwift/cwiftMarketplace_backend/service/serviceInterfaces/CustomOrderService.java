package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.CustomOrder;

import java.util.List;

public interface CustomOrderService {

    public CustomOrder createCustomOrder( CustomOrder customerOrder);
    public CustomOrder getCustomOrder( String orderID);
    public List<CustomOrder> getAllCustomOrders();
    public List<CustomOrder> getAllCustomOrdersByUserID( String userID);
    public String deleteCustomOrder(String orderID);
    public CustomOrder editCustomOrder( String orderID, CustomOrder customerOrder);

}
