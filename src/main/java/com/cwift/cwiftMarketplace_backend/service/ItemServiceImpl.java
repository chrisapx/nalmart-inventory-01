package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Item;
import com.cwift.cwiftMarketplace_backend.model.OrderStatus;
import com.cwift.cwiftMarketplace_backend.repository.ItemRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.ItemService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl ( ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem ( Item item ) {
        return itemRepository.save ( item );
    }

    @Override
    public List<Item> addManyItems ( List<Item> items ) {
        return itemRepository.saveAll ( items );
    }

    @Override
    public Item getItemById ( long id ) {
        return itemRepository.findById ( id ).get ();
    }

    @Override
    public List<Item> getAllItems () {
        return itemRepository.findAll ();
    }

    @Override
    public Item getItemBySKU ( String sku ) {
        return itemRepository.findBySku(sku);
    }

    @Override
    public Item editItem ( long id, Item item ) {
//        Edit syntax here
        return null;
    }

    @Override
    public String deleteItemBySku ( String sku ) {
        itemRepository.deleteBySku ( sku );
        return "Item " + sku + " Deleted successfully";
    }

    @Override
    public List<String> getOrderStatusList () {
        return Arrays.stream( OrderStatus.values () ).map ( Enum::name ).toList ();
    }


}
