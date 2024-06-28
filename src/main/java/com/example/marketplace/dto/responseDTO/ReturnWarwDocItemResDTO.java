package com.example.marketplace.dto.responseDTO;

import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ReturnDoc;
import com.example.marketplace.entity.ReturnWarwDoc;
import com.example.marketplace.entity.StoreProduct;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ReturnWarwDocItemResDTO {
    Long id;
    ReturnWarwDocResDTO returnWarwDocResDTO;
    StoreProductResDTO storeProductResDTO;
    ProductResDTO productResDTO;
    Long count;
}
