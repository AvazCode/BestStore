package com.example.marketplace.repostory;

import com.example.marketplace.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepostory extends JpaRepository<Company,Long> {
}
