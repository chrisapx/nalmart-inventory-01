package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);
    public List<Item> addManyItems(List<Item> items);
    public Item getItemById(long id);
    public List<Item> getAllItems();
    public Item getItemBySKU(String sku);
    public Item editItem(long id, Item item);
    public String deleteItemBySku(String sku);
    public List<String> getOrderStatusList();
}
