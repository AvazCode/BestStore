package com.example.marketplace.dto.responseDTO;

import com.example.marketplace.entity.StoreProduct;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SellDocItemResDTO {
    Long id;
    SellDocResDTO sellDocResDTO;
    StoreProduct storeProductResDTO;
    Long count;
    Long price;
}
