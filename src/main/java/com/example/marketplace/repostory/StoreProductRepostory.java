package com.example.marketplace.repostory;

import com.example.marketplace.entity.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreProductRepostory extends JpaRepository<StoreProduct,Long> {
}
