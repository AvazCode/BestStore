package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.service.SellDocService;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SellDocItemReqDTO {
    Long sellDoc_id;
    Long storeProduct_id;
    Long count;
    Long price;

}
