package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.model.Category;
import com.cwift.cwiftMarketplace_backend.model.Item;
import com.cwift.cwiftMarketplace_backend.service.ItemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(originPatterns = "*")
public class ItemController {

    private final ItemServiceImpl itemServiceImpl;

    public ItemController ( ItemServiceImpl itemService ) {
        this.itemServiceImpl = itemService;
    }

    @PostMapping("/item")
    public ResponseEntity<Item> addItem( @RequestBody Item item ){
        return ResponseEntity.ok (itemServiceImpl.addItem ( item ));
    }

    @PostMapping
    public ResponseEntity<List<Item>> addManyItem( @RequestBody List<Item> items ){
        return ResponseEntity.ok (itemServiceImpl.addManyItems ( items ));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok (itemServiceImpl.getAllItems ());
    }

    @GetMapping("/names")
    public ResponseEntity<List<Item>> getAllItemsWithNames(@RequestParam List<String> names){
        return ResponseEntity.ok (itemServiceImpl.getAllInNames (names));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemByID( @PathVariable long itemId ){
        return ResponseEntity.ok (itemServiceImpl.getItemById ( itemId ));
    }

    @GetMapping("/item")
    public ResponseEntity<Item> getItemBySku( @RequestParam String sku ){
        return ResponseEntity.ok (itemServiceImpl.getItemBySKU ( sku ));
    }

    @PutMapping("/update")
    public ResponseEntity<Item> editItem( @RequestParam long itemID, @RequestBody Item item ) throws Exception {
        return ResponseEntity.ok (itemServiceImpl.editItem ( itemID, item ));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItemBySku( @RequestParam String sku ){
        return ResponseEntity.ok (itemServiceImpl.deleteItemBySku ( sku ));
    }

    @DeleteMapping("/{itemID}")
    public ResponseEntity<String> deleteItemByItemID( @PathVariable long itemID ){
        return ResponseEntity.ok (itemServiceImpl.deleteItemByItemID ( itemID ));
    }


    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getItemCategoryList(  ){
        return ResponseEntity.ok (itemServiceImpl.getCategoryList ( ));
    }

}
