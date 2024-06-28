package com.example.marketplace.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ReturnWarwDocItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    ReturnWarwDoc returnWarwDoc;
    @ManyToOne
    StoreProduct storeProduct;
    @ManyToOne
    Product product;
    Long count;
}
