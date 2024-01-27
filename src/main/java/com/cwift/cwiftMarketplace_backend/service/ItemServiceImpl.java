package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Category;
import com.cwift.cwiftMarketplace_backend.model.Item;
import com.cwift.cwiftMarketplace_backend.model.OrderStatus;
import com.cwift.cwiftMarketplace_backend.repository.ItemRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl ( ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @Override
//    @Secure({"ADMIN", "VENDOR"})
    public Item addItem ( Item item ) {
        return itemRepository.save ( item );
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR"})
    public List<Item> addManyItems ( List<Item> items ) {
        return itemRepository.saveAll ( items );
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public Item getItemById ( long id ) {
        return itemRepository.findById ( id ).get ();
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public List<Item> getAllItems () {
        return itemRepository.findAll ();
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public Item getItemBySKU ( String sku ) {
        return itemRepository.findBySku(sku);
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public Item editItem ( long id, Item item ) {
//        Edit syntax here
        return null;
    }

    @Override
    //    @Secure({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public String deleteItemBySku ( String sku ) {
        itemRepository.deleteBySku ( sku );
        return "Item " + sku + " Deleted successfully";
    }

    @Override
    public List<Category> getCategoryList () {
        return Arrays.stream( Category.values () ).collect( Collectors.toList());
    }

    @Override
    public List<String> getSubCategoryList ( Category category ) {
        return null;
    }

}
