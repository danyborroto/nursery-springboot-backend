package com.nursery.app.features.servicio.service;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.servicio.dto.ServicioRequestDTO;
import com.nursery.app.features.servicio.dto.ServicioResponseDTO;
import com.nursery.app.features.servicio.entity.Servicio;
import com.nursery.app.features.servicio.repository.ServicioRepository;
import com.nursery.app.util.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public ResponseEntity<List<ServicioResponseDTO>> getAll() {
        List<ServicioResponseDTO> servicios = servicioRepository.findAll().stream()
                .map(Mappers::toServicioResponseDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(servicios);
    }

    public ResponseEntity<ServicioResponseDTO> getOne(Integer servicioId) {
        Servicio servicio = servicioRepository.findById(servicioId)
                .orElseThrow(() -> new FeatureNotFoundException("Servicio", servicioId));
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toServicioResponseDTO(servicio));
    }

    public ResponseEntity<ServicioResponseDTO> create(ServicioRequestDTO dto) {
        Servicio servicio = new Servicio();
        servicio.setServiceName(dto.getServiceName());
        servicio.setSelectable(dto.getSelectable());
        servicio.setActive(dto.getActive());
        Servicio saved = servicioRepository.save(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toServicioResponseDTO(saved));
    }

    public ResponseEntity<ServicioResponseDTO> update(Integer serviceId, ServicioRequestDTO dto) {
        Servicio service = servicioRepository.findById(serviceId)
                .orElseThrow(() -> new FeatureNotFoundException("Service", serviceId));
        service.setServiceName(dto.getServiceName());
        service.setSelectable(dto.getSelectable());
        service.setActive(dto.getActive());

        Servicio saved = servicioRepository.save(service);
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toServicioResponseDTO(saved));
    }
    public ResponseEntity<Void> delete(Integer servicioId){
        Servicio servicio = servicioRepository.findById(servicioId)
                .orElseThrow(()->new FeatureNotFoundException("Servicio", servicioId));
        servicio.setActive(false);
        servicioRepository.save(servicio);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
