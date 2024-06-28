package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.dto.responseDTO.ProductResDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StoreDocItemReqDTO {
    Long storeDoc_id;
    Long product_id;
    Long count;
}
