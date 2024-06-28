package com.example.marketplace.dto.responseDTO;

import com.example.marketplace.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResDTO {
    Long id;
    String name;
    List<ProductResDTO> productResDTOList;
}
