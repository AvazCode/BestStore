package com.example.marketplace.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ReturnWarwDocResDTO {
    Long id;
    String docNumber;
    LocalDateTime date;
}
