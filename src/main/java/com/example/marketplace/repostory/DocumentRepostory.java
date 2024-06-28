package com.example.marketplace.repostory;

import com.example.marketplace.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepostory extends JpaRepository<Document,Long> {
}
