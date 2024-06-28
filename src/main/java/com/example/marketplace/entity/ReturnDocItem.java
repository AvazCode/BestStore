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
public class ReturnDocItem {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         Long id;
         @ManyToOne
         ReturnDoc returnDoc;
         @ManyToOne
         StoreProduct storeProduct;
         Long count;

}
