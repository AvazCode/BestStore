package com.example.marketplace.repostory;

import com.example.marketplace.entity.SellDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDocRepostory extends JpaRepository<SellDoc,Long> {
}
