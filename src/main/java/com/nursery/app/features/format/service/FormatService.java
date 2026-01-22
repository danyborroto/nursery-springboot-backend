package com.nursery.app.features.format.service;
import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.format.dto.FormatRequestDTO;
import com.nursery.app.features.format.dto.FormatResponseDTO;
import com.nursery.app.features.format.entity.Format;
import com.nursery.app.features.format.repository.FormatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatService {
    private final FormatRepository formatRepository;

    public FormatService(FormatRepository formatRepository) {
        this.formatRepository = formatRepository;
    }

    public ResponseEntity<List<FormatResponseDTO>> getAll() {
        List<Format> formatList = formatRepository.findAll();
        List<FormatResponseDTO> responseDTOS = formatList.stream()
                .map(this::MapToResponseDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    public ResponseEntity<FormatResponseDTO> getById(Integer formatId){
        Format format = formatRepository.findById(formatId)
                .orElseThrow(()->new FeatureNotFoundException("Format", formatId));
        return ResponseEntity.status(HttpStatus.OK).body(MapToResponseDTO(format));
    }

    public ResponseEntity<FormatResponseDTO> create(FormatRequestDTO requestDTO){
        Format format = new Format();
        format.setFormatName(requestDTO.getFormatName());
        format.setActive(requestDTO.getActiva());
        return ResponseEntity.status(HttpStatus.CREATED).body(MapToResponseDTO(formatRepository.save(format)));
    }

    public ResponseEntity<FormatResponseDTO> update(Integer formatId, FormatRequestDTO requestDTO){
        Format format = formatRepository.findById(formatId)
                .orElseThrow(()->new FeatureNotFoundException("Format", formatId));
        format.setFormatName(requestDTO.getFormatName());
        format.setActive(requestDTO.getActiva());
        return ResponseEntity.status(HttpStatus.OK).body(MapToResponseDTO(formatRepository.save(format)));
    }

    public ResponseEntity<Void> delete(Integer formatId){
        Format format = formatRepository.findById(formatId)
                .orElseThrow(()->new FeatureNotFoundException("Format", formatId));
        format.setActive(false);
        formatRepository.save(format);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private FormatResponseDTO MapToResponseDTO(Format format) {
        FormatResponseDTO responseDTO = new FormatResponseDTO(
                format.getFormatId(),
                format.getFormatName(),
                format.getActive());
        return responseDTO;
    }
}
