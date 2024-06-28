package com.example.marketplace.repostory;

import com.example.marketplace.entity.StoreDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDocRepostory extends JpaRepository<StoreDoc,Long> {
}
