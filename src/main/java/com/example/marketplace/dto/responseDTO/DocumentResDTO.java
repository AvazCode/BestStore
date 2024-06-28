package com.example.marketplace.dto.responseDTO;

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
public class DocumentResDTO {
    Long id;
    CompanyResDTO companyResDTO;
    LocalDateTime date;
    String document_number;
}
