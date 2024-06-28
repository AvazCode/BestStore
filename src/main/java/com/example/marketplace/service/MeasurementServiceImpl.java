package com.example.marketplace.service;

import com.example.marketplace.dto.requestDTO.MeasurementReqDTO;
import com.example.marketplace.dto.requestDTO.MeasurementReqDTO;
import com.example.marketplace.dto.responseDTO.MeasurementResDTO;
import com.example.marketplace.dto.responseDTO.MeasurementResDTO;
import com.example.marketplace.entity.Measurement;
import com.example.marketplace.mapper.MeasurementReqMapper;
import com.example.marketplace.mapper.MeasurementResMapper;
import com.example.marketplace.repostory.MeasurementRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService{
    private final MeasurementRepostory measurementRepostory;
    private final MeasurementReqMapper measurementReqMapper;
    private final MeasurementResMapper measurementResMapper;
    @Override
    public List<MeasurementResDTO> getALLMeasurement() {
        return measurementResMapper.toDTOs(measurementRepostory.findAll());
    }

    @Override
    public MeasurementResDTO getMeasurementById(Long id) {

        return measurementResMapper.toDTO(measurementRepostory.getReferenceById(id));
    }

    @Override
    public MeasurementResDTO createMeasurement(MeasurementReqDTO measurementReqDTO) {

        return measurementResMapper.toDTO(measurementRepostory.save(measurementReqMapper.toENTITY(measurementReqDTO)));
    }

    @Override
    public MeasurementResDTO updateMeasurement(Long id, MeasurementReqDTO measurementReqDTO) {
        Measurement measurement = measurementRepostory.getReferenceById(id);
        measurement.setName(measurementReqDTO.getName());
        return measurementResMapper.toDTO(measurementRepostory.save(measurement));
    }

    @Override
    public void deleteMeasurementById(Long id) {
        measurementRepostory.deleteById(id);
    }
}
