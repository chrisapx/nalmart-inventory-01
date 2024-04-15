package com.cwift.cwiftMarketplace_backend.controller;

import com.cwift.cwiftMarketplace_backend.model.Category;
import com.cwift.cwiftMarketplace_backend.model.SubCategory;
import com.cwift.cwiftMarketplace_backend.service.ItemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ItemServiceImpl itemService;

    public CategoryController ( ItemServiceImpl itemService ) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory( @RequestBody Category category  ){
        return ResponseEntity.ok (itemService.addCategory ( category ));
    }

    @PostMapping("/sub")
    public ResponseEntity<SubCategory> addSubCategory( @RequestBody SubCategory subCategory ){
        return ResponseEntity.ok (itemService.addSubCategory ( subCategory ));
    }

    @GetMapping("/sub")
    public ResponseEntity<List<SubCategory>> findAll(  ){
        return ResponseEntity.ok (itemService.getAllSubCategories (  ));
    }


    @GetMapping
    public ResponseEntity<List<Category>> getItemCategoryList(  ){
        return ResponseEntity.ok (itemService.getCategoryList ( ));
    }

    @GetMapping("/{categoryID}")
    public ResponseEntity<List<SubCategory>> getItemSubCategoryList( @PathVariable long categoryID ){
        return ResponseEntity.ok (itemService.getSubCategoryList ( categoryID ));
    }

}
