package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Category;
import com.cwift.cwiftMarketplace_backend.model.Item;
import com.cwift.cwiftMarketplace_backend.repository.ItemRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl ( ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @Override
//    @Secured({"ADMIN", "VENDOR"})
    public Item addItem ( Item item ) {
        if(item.getGlobalPrice () != 0){
            if(item.getGlobalPrice () >= item.getPrice () ){
                item.setDiscount ( ((item.getGlobalPrice () - item.getPrice ()) / item.getGlobalPrice ()) * 100 );
            }
        }
        return itemRepository.save ( item );
    }

    @Override
    //    @Secured({"ADMIN", "VENDOR"})
    public List<Item> addManyItems ( List<Item> items ) {
        return itemRepository.saveAll ( items );
    }

    @Override
    //    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public Item getItemById ( long id ) {
        return itemRepository.findById ( id ).get ();
    }

    @Override
    //    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public List<Item> getAllItems () {
        return itemRepository.findAll ();
    }

    @Override
    public List<Item> getAllInNames ( List<String> names ) {
        log.info ( "Names searched" );
        return itemRepository.findByNameIn ( names );
    }

    @Override
    //    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN", "USER"})
    public Item getItemBySKU ( String sku ) {
        return itemRepository.findBySku(sku);
    }

    @Override
    //    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public Item editItem ( long id, Item item ) {
//        Edit syntax here
        return null;
    }

    @Override
//    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public String deleteItemBySku ( String sku ) {
        itemRepository.deleteBySku ( sku );
        return "Item " + sku + " Deleted successfully";
    }

    @Override
    public List<Category> getCategoryList () {
        log.info("Viewed item category list");
        return Arrays.stream( Category.values () ).collect( Collectors.toList());
    }

    @Override
    public List<String> getSubCategoryList ( Category category ) {
        return null;
    }

}
