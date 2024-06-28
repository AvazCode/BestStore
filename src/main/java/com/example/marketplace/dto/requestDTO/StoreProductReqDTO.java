package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.dto.responseDTO.ProductResDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StoreProductReqDTO {
    Long product_id;
    Double amount;
}
