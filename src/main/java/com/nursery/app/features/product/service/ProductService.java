package com.nursery.app.features.product.service;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.format.entity.Format;
import com.nursery.app.features.format.repository.FormatRepository;
import com.nursery.app.features.product.dto.ProductRequestDTO;
import com.nursery.app.features.product.dto.ProductResponseDTO;
import com.nursery.app.features.product.entity.Product;
import com.nursery.app.features.product.repository.ProductRepository;
import com.nursery.app.util.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final FormatRepository formatRepository;

    public ProductService(ProductRepository productRepository, FormatRepository formatRepository) {
        this.productRepository = productRepository;
        this.formatRepository = formatRepository;
    }

    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> productos = productRepository.findAll().stream()
                .map(product -> Mappers.toProductResponseDTO(product))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    public ResponseEntity<ProductResponseDTO> getById(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Product", productId));
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toProductResponseDTO(product));
    }

    public ResponseEntity<ProductResponseDTO> create(ProductRequestDTO requestDTO) {
        Format format = formatRepository.findById(requestDTO.getFormat())
                .orElseThrow(() -> new FeatureNotFoundException("Format", requestDTO.getFormat()));
        Product product = new Product();
        product.setProductName(requestDTO.getProductName());
        product.setProductDescription(requestDTO.getProductDescription());
        product.setProductPrice(requestDTO.getProductPrice());
        product.setProductCount(requestDTO.getProductCount());
        product.setProductHeight(requestDTO.getProductHeight());
        product.setProductHeightUnit(requestDTO.getProductHeightUnit());
        product.setFormat(format);
        product.setActive(requestDTO.getActive());
        Product saved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toProductResponseDTO(saved));
    }

    public ResponseEntity<ProductResponseDTO> update(Integer productId, ProductRequestDTO requestDTO) {
        Format format = formatRepository.findById(requestDTO.getFormat())
                .orElseThrow(() -> new FeatureNotFoundException("Format", requestDTO.getFormat()));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Product", productId));
        product.setProductName(requestDTO.getProductName());
        product.setProductDescription(requestDTO.getProductDescription());
        product.setProductPrice(requestDTO.getProductPrice());
        product.setProductCount(requestDTO.getProductCount());
        product.setProductHeight(requestDTO.getProductHeight());
        product.setProductHeightUnit(requestDTO.getProductHeightUnit());
        product.setActive(requestDTO.getActive());
        product.setFormat(format);

        Product saved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toProductResponseDTO(saved));
    }

    public ResponseEntity<Void> delete(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new FeatureNotFoundException("Product", productId));
        product.setActive(false);
        Product saved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
