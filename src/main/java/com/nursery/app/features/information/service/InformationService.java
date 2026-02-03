package com.nursery.app.features.information.service;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.information.dto.InformationRequestDTO;
import com.nursery.app.features.information.dto.InformationResponseDTO;
import com.nursery.app.features.information.entity.Information;
import com.nursery.app.features.information.repository.InformationRepository;
import com.nursery.app.util.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    private final InformationRepository infoRepository;

    public InformationService(InformationRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public ResponseEntity<List<InformationResponseDTO>> getAll() {
        List<InformationResponseDTO> info = infoRepository.findAll().stream()
                .map(Mappers::toInfoResponseDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(info);
    }

    public ResponseEntity<InformationResponseDTO> create(InformationRequestDTO dto) {
        Information info = new Information();
        info.setNurseryName(dto.getNurseryName());
        info.setDescription(dto.getDescription());
        info.setHistory(dto.getHistory());
        info.setAddress(dto.getAddress());
        info.setEmail(dto.getEmail());
        info.setPhonePrimary(dto.getPhonePrimary());
        info.setPhoneSecondary(dto.getPhoneSecondary());

        Information saved = infoRepository.save(info);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toInfoResponseDTO(saved));
    }

    public ResponseEntity<InformationResponseDTO> update(Integer id, InformationRequestDTO dto) {
        Information info = infoRepository.findById(id)
                .orElseThrow(() -> new FeatureNotFoundException("Information", id));
        info.setNurseryName(dto.getNurseryName());
        info.setDescription(dto.getDescription());
        info.setHistory(dto.getHistory());
        info.setAddress(dto.getAddress());
        info.setEmail(dto.getEmail());
        info.setPhonePrimary(dto.getPhonePrimary());
        info.setPhoneSecondary(dto.getPhoneSecondary());

        Information saved = infoRepository.save(info);
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toInfoResponseDTO(saved));

    }

    public ResponseEntity<Void> delete(Integer id) {
        Information info = infoRepository.findById(id)
                .orElseThrow(() -> new FeatureNotFoundException("Information", id));
        infoRepository.delete(info);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
