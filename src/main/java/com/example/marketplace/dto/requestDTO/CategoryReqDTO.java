package com.example.marketplace.dto.requestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReqDTO {
    Long id;
    String name;
}
