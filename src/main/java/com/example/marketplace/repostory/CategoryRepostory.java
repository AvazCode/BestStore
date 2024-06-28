package com.example.marketplace.repostory;

import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepostory extends JpaRepository<Category,Long> {

}
