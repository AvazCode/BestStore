package com.example.marketplace.repostory;

import com.example.marketplace.entity.ReturnWarwDocItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnWarwDocItemRepostory extends JpaRepository<ReturnWarwDocItem,Long> {

}
