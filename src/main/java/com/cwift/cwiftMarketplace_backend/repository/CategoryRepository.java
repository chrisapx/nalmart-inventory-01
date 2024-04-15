package com.cwift.cwiftMarketplace_backend.repository;

import com.cwift.cwiftMarketplace_backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
