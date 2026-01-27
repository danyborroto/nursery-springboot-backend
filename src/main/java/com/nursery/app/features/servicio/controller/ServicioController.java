package com.nursery.app.features.servicio.controller;

import com.nursery.app.features.servicio.dto.ServicioRequestDTO;
import com.nursery.app.features.servicio.dto.ServicioResponseDTO;
import com.nursery.app.features.servicio.service.ServicioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public ResponseEntity<List<ServicioResponseDTO>> getAll(){
        return servicioService.getAll();
    }

    @GetMapping("/{servicioId}")
    public ResponseEntity<ServicioResponseDTO> getoOne(@PathVariable Integer servicioId){
        return servicioService.getOne(servicioId);
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDTO> create(@Valid @RequestBody ServicioRequestDTO dto){
        return servicioService.create(dto);
    }
    @PutMapping("/{servicioId}")
    public ResponseEntity<ServicioResponseDTO> update(@PathVariable Integer servicioId, @Valid @RequestBody ServicioRequestDTO dto){
        return servicioService.update(servicioId, dto);
    }

    @DeleteMapping("/{servicioId}")
    public ResponseEntity<Void> delete(@PathVariable Integer servicioId){
        return servicioService.delete(servicioId);
    }
}
