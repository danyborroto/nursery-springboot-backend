package com.nursery.app.features.product.controller;

import com.nursery.app.features.product.dto.ProductRequestDTO;
import com.nursery.app.features.product.dto.ProductResponseDTO;
import com.nursery.app.features.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Integer productId) {
        return productService.getById(productId);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.create(productRequestDTO);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Integer productId, @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.update(productId, productRequestDTO);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Integer productId){
        return productService.delete(productId);
    }
}
