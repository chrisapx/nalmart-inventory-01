package com.cwift.cwiftMarketplace_backend.service.serviceInterfaces;

import com.cwift.cwiftMarketplace_backend.model.Category;
import com.cwift.cwiftMarketplace_backend.model.Item;
import com.cwift.cwiftMarketplace_backend.model.SubCategory;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);
    public List<Item> addManyItems(List<Item> items);

    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    long countTotalItems ();

    public Item getItemById( long id);
    public List<Item> getAllItems();
    public List<Item> getAllInNames(List<String> names);
    public Item getItemBySKU(String sku);

    Item editItemDescriptionOrWhatIsInTheBox ( String sku, Item item );

    //    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    Item approveItem ( String sku );

    public Item editItem( long id, Item item) throws Exception;
    public String deleteItemBySku(String sku);

    //    @Secured({"ADMIN", "VENDOR", "SUPER_ADMIN"})
    String deleteItemByItemID ( long itmID );

    public Category addCategory(Category category);
    public SubCategory addSubCategory(SubCategory subCategory);
    public List<Category> getCategoryList();

    List<SubCategory> getSubCategoryList ( long categoryID );

    List<SubCategory> getAllSubCategories ();
}
