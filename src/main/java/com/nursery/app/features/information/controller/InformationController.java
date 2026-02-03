package com.nursery.app.features.information.controller;

import com.nursery.app.features.information.dto.InformationRequestDTO;
import com.nursery.app.features.information.dto.InformationResponseDTO;
import com.nursery.app.features.information.service.InformationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/information")
public class InformationController {
    private final InformationService info;

    public InformationController(InformationService info) {
        this.info = info;
    }

    @GetMapping
    public ResponseEntity<List<InformationResponseDTO>> getAll(){
        return info.getAll();
    }

    @PostMapping
    public ResponseEntity<InformationResponseDTO> create(@Valid @RequestBody InformationRequestDTO dto){
        return info.create(dto);
    }

    @PutMapping("/{infoId}")
    public ResponseEntity<InformationResponseDTO> update(@PathVariable Integer infoId, @Valid @RequestBody InformationRequestDTO dto){
        return info.update(infoId, dto);
    }

    @DeleteMapping("/{infoId}")
    public ResponseEntity<Void> delete(@PathVariable Integer infoId){
        return info.delete(infoId);
    }

}
