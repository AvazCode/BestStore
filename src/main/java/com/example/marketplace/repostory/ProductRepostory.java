package com.example.marketplace.repostory;

import com.example.marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepostory extends JpaRepository<Product,Long> {
    List<Product> findByCategoryId(Long categoryId);
}
