package com.example.marketplace.repostory;

import com.example.marketplace.entity.StoreDocItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDocItemRepostory extends JpaRepository<StoreDocItem,Long> {
}
