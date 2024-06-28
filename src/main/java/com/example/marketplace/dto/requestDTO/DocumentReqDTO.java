package com.example.marketplace.dto.requestDTO;

import com.example.marketplace.entity.Company;
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
public class DocumentReqDTO {
    Long company_id;
    LocalDateTime date;
    String document_number;

}
