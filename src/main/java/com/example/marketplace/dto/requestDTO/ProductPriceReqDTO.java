package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceReqDTO {
    Long product_id;
    Double price;
    LocalDateTime date;
    Boolean status;
}
