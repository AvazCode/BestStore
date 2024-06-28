package com.example.marketplace.repostory;

import com.example.marketplace.entity.ReturnDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnDocRepostory extends JpaRepository<ReturnDoc,Long> {
}
