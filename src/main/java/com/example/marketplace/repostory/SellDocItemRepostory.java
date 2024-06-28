package com.example.marketplace.repostory;

import com.example.marketplace.entity.SellDocItem;
import com.example.marketplace.mapper.CommonMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDocItemRepostory extends JpaRepository<SellDocItem,Long> {
}
