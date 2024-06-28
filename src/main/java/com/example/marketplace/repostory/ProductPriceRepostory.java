package com.example.marketplace.repostory;

import com.example.marketplace.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepostory extends JpaRepository<ProductPrice,Long> {

}
