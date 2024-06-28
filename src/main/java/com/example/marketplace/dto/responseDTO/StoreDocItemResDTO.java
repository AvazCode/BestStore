package com.example.marketplace.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StoreDocItemResDTO {
    Long id;
    StoreDocResDTO storeDocResDTO;
    ProductResDTO productResDTO;
    Long count;
}
