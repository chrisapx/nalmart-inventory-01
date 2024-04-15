package com.cwift.cwiftMarketplace_backend.service;

import com.cwift.cwiftMarketplace_backend.model.Category;
import com.cwift.cwiftMarketplace_backend.model.Item;
import com.cwift.cwiftMarketplace_backend.model.SubCategory;
import com.cwift.cwiftMarketplace_backend.repository.CategoryRepository;
import com.cwift.cwiftMarketplace_backend.repository.ItemRepository;
import com.cwift.cwiftMarketplace_backend.repository.SubCategoryRepository;
import com.cwift.cwiftMarketplace_backend.service.serviceInterfaces.ItemService;
import com.cwift.cwiftMarketplace_backend.utils.UpdateHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UpdateHelper updateHelper;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    public ItemServiceImpl ( ItemRepository itemRepository, UpdateHelper updateHelper, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository ) {
        this.itemRepository = itemRepository;
        this.updateHelper = updateHelper;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public Item addItem ( Item item ) {
        if(item.getGlobalPrice () != 0){
            if(item.getGlobalPrice () >= item.getPrice () ){
                item.setDiscount ( ((item.getGlobalPrice () - item.getPrice ()) / item.getGlobalPrice ()) * 100 );
            }
        }
        log.info ( "Item added with name: " + item.getDisplayName () );
        return itemRepository.save ( item );
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
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
    public List<Item> getAllInNames ( List<String> names ) {
        log.info ( "Names searched" );
        return itemRepository.findByNameIn ( names );
    }

    @Override
    public Item getItemBySKU ( String sku ) {
        return itemRepository.findBySku(sku);
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public Item editItemDescriptionOrWhatIsInTheBox ( String sku, Item newItem ) {
        try{
            Item oldItem = itemRepository.findBySku ( sku );
            if (newItem.getDescription () != null) oldItem.setDescription ( newItem.getDescription () );
            if (newItem.getWhatIsInTheBox () != null) oldItem.setWhatIsInTheBox ( newItem.getWhatIsInTheBox () );

            return itemRepository.save ( oldItem );
        }
        catch ( Exception e ) {
            throw new RuntimeException ( e );
        }
    }

    @Override
    @Secured ({"ADMIN", "SUPER_ADMIN", "VENDOR"})
    public Item approveItem ( String sku ) {
        try{
            Item oldItem = itemRepository.findBySku ( sku );
            oldItem.setApproved ( true );
            return itemRepository.save ( oldItem );
        }
        catch ( Exception e ) {
            throw new RuntimeException ( e );
        }
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public Item editItem(long itemID, Item newItemAttributes) throws Exception {
        try {
            Item oldItem = itemRepository.findByItemID(itemID);
            if (oldItem != null) {
                newItemAttributes.setItemID ( oldItem.getItemID () );
                newItemAttributes.setSku ( oldItem.getSku () );
                newItemAttributes.setDateCreated ( oldItem.getDateCreated () );
                updateHelper.mergeObjects(oldItem, newItemAttributes);
                oldItem.setDateModified ( new Date () );
                return itemRepository.save(oldItem);
            } else {
                throw new Exception ("Item with ID " + itemID + " not found");
            }
        } catch (Exception e) {
            throw new Exception ( e + "Item with ID " + itemID + " not found");
        }
    }

    @Override
    @Transactional
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public String deleteItemBySku ( String sku ) {
        itemRepository.deleteBySku ( sku );
        return "Item " + sku + " Deleted successfully";
    }

    @Override
    @Transactional
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public String deleteItemByItemID ( long itmID ) {
        itemRepository.deleteByItemID ( itmID );
        return "Item " + itmID + " Deleted successfully";
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public Category addCategory ( Category category ) {
        log.info ( "Adding category " + category.getName () );
        return categoryRepository.save ( category );
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public SubCategory addSubCategory ( SubCategory subCategory ) {
        log.info ( "Adding sub category " + subCategory.getName () );
        return subCategoryRepository.save ( subCategory );
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public List<Category> getCategoryList () {
        log.info("Viewed item category list");
        return categoryRepository.findAll ();
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public List<SubCategory> getSubCategoryList ( long categoryID ) {
        return subCategoryRepository.findAllByParentID(categoryID);
    }

    @Override
    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    public List<SubCategory> getAllSubCategories (  ) {
        return subCategoryRepository.findAll ();
    }

}
