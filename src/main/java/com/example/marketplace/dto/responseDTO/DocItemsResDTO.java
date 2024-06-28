package com.example.marketplace.dto.responseDTO;

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
public class DocItemsResDTO {
    Long id;
    DocumentResDTO documentResDTO;
    ProductResDTO productResDTO;
    Integer come_price;
    Integer count;
}
