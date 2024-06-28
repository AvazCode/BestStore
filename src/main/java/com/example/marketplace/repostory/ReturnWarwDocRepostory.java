package com.example.marketplace.repostory;

import com.example.marketplace.entity.ReturnWarwDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnWarwDocRepostory extends JpaRepository<ReturnWarwDoc,Long> {
}
