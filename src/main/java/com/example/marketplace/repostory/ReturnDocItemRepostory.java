package com.example.marketplace.repostory;

import com.example.marketplace.entity.ReturnDocItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnDocItemRepostory extends JpaRepository<ReturnDocItem,Long> {
}
