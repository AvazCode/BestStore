package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.entity.Document;
import com.example.marketplace.entity.Product;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class DocItemsReqDTO {
    Long document_id;
    Long product_id;
    Integer come_price;
    Integer count;
}
