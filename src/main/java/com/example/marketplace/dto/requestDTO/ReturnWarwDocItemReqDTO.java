package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.entity.Product;
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
public class ReturnWarwDocItemReqDTO {
    Long returnWarwDoc_id;
    Long storeProduct_id;
    Long product_id;
    Long count;
}
