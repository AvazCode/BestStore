package com.example.marketplace.dto.responseDTO;

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
public class ProductPriceResDTO {
    Long id;
    ProductResDTO productResDTO;
    Double price;
    LocalDateTime date;
    Boolean status;
}
