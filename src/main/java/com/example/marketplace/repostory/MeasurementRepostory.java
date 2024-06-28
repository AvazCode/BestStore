package com.example.marketplace.repostory;

import com.example.marketplace.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepostory extends JpaRepository<Measurement,Long> {
}
