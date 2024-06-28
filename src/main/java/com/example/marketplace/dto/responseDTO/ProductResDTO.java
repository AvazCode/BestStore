package com.example.marketplace.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductResDTO {
    Long id;
    String name;
    CategoryResDTO categoryResDTO;
    MeasurementResDTO measurementResDTO;
    Integer amount;
}

