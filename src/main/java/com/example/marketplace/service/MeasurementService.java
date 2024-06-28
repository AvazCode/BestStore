package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.MeasurementReqDTO;
import com.example.marketplace.dto.responseDTO.MeasurementResDTO;

import java.util.List;

public interface MeasurementService {
    List<MeasurementResDTO> getALLMeasurement();
    MeasurementResDTO getMeasurementById(Long id);
    MeasurementResDTO createMeasurement(MeasurementReqDTO measurementReqDTO);
    MeasurementResDTO updateMeasurement(Long id ,MeasurementReqDTO measurementReqDTO);
    void deleteMeasurementById(Long id);
}
