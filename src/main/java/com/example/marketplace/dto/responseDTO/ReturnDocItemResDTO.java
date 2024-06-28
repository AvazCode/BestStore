package com.example.marketplace.dto.responseDTO;

import com.example.marketplace.entity.ReturnDoc;
import com.example.marketplace.entity.StoreProduct;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDocItemResDTO {
    Long id;
    ReturnDocResDTO returnDocResDTO;
    StoreProductResDTO storeProductResDTO;
    Long count;
}
