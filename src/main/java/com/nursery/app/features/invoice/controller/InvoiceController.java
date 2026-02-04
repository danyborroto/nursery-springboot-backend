package com.nursery.app.features.invoice.controller;

import com.nursery.app.features.cart_product.dto.CartProductResponseDTO;
import com.nursery.app.features.cart_servicio.dto.CartServicioResponseDTO;
import com.nursery.app.features.invoice.dto.InvoiceRequestDTO;
import com.nursery.app.features.invoice.dto.InvoiceResponseDTO;
import com.nursery.app.features.invoice.service.InvoiceService;
import com.nursery.app.features.invoice_product.dto.InvoiceProductResponseDTO;
import com.nursery.app.features.invoice_servicio.dto.InvoiceServiceResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponseDTO> getOne(@PathVariable Integer invoiceId) {
        return invoiceService.getOne(invoiceId);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> create(@Valid @RequestBody InvoiceRequestDTO dto) {
        return invoiceService.create(dto);
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponseDTO> update(@PathVariable Integer invoiceId, @Valid @RequestBody InvoiceRequestDTO dto) {
        return invoiceService.update(invoiceId, dto);
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<Void> delete(@PathVariable Integer invoiceId) {
        return invoiceService.delete(invoiceId);
    }

    @PostMapping("/{invoiceId}/product")
    public ResponseEntity<InvoiceProductResponseDTO> addProduct(@PathVariable Integer invoiceId, @Valid @RequestBody CartProductResponseDTO dto) {
        return invoiceService.addProduct(invoiceId, dto);
    }

    @PostMapping("/{invoiceId}/service")
    public ResponseEntity<InvoiceServiceResponseDTO> addService(@PathVariable Integer invoiceId, @Valid @RequestBody CartServicioResponseDTO dto){
        return invoiceService.addService(invoiceId, dto);
    }
}
