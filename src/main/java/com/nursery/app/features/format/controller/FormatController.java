package com.nursery.app.features.format.controller;

import com.nursery.app.features.format.dto.FormatRequestDTO;
import com.nursery.app.features.format.dto.FormatResponseDTO;
import com.nursery.app.features.format.service.FormatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formats")
public class FormatController {
    private final FormatService formatService;
    public FormatController(FormatService formatService){
        this.formatService=formatService;
    }

    @GetMapping
    public ResponseEntity<List<FormatResponseDTO>> getAll(){
        return formatService.getAll();
    }

    @GetMapping("/{formatId}")
    public ResponseEntity<FormatResponseDTO> findById(@PathVariable Integer formatId){
        return formatService.getById(formatId);
    }

    @PostMapping
    public ResponseEntity<FormatResponseDTO> create(@Valid @RequestBody FormatRequestDTO requestDTO){
        return formatService.create(requestDTO);
    }

    @PutMapping("/{formatId}")
    public ResponseEntity<FormatResponseDTO> update(@PathVariable Integer formatId,
                                                    @Valid @RequestBody FormatRequestDTO requestDTO){
        return formatService.update(formatId, requestDTO);
    }

    @DeleteMapping("/{formatId}")
    public ResponseEntity<Void> delete(@PathVariable Integer formatId){
        return formatService.delete(formatId);
    }
}
