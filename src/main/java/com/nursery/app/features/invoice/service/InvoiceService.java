package com.nursery.app.features.invoice.service;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.cart_product.dto.CartProductResponseDTO;
import com.nursery.app.features.cart_servicio.dto.CartServicioResponseDTO;
import com.nursery.app.features.invoice.dto.InvoiceRequestDTO;
import com.nursery.app.features.invoice.dto.InvoiceResponseDTO;
import com.nursery.app.features.invoice.entity.Invoice;
import com.nursery.app.features.invoice.repository.InvoiceRepository;
import com.nursery.app.features.invoice_product.dto.InvoiceProductResponseDTO;
import com.nursery.app.features.invoice_product.entity.InvoiceProduct;
import com.nursery.app.features.invoice_product.repository.InvoiceProductRepository;
import com.nursery.app.features.invoice_servicio.dto.InvoiceServiceResponseDTO;
import com.nursery.app.features.invoice_servicio.entity.InvoiceServiceEntity;
import com.nursery.app.features.invoice_servicio.repository.InvoiceServiceRepository;
import com.nursery.app.features.product.entity.Product;
import com.nursery.app.features.product.repository.ProductRepository;
import com.nursery.app.features.servicio.entity.Servicio;
import com.nursery.app.features.servicio.repository.ServicioRepository;
import com.nursery.app.features.users.entity.User;
import com.nursery.app.features.users.repository.UserRepository;
import com.nursery.app.util.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final ServicioRepository servicioRepository;
    private final InvoiceServiceRepository invoiceServiceRepository;
    private final InvoiceProductRepository invoiceProductRepository;
    private final UserRepository userRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, ProductRepository productRepository,
                          ServicioRepository servicioRepository,
                          InvoiceServiceRepository invoiceServiceRepository,
                          InvoiceProductRepository invoiceProductRepository,
                          UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
        this.servicioRepository = servicioRepository;
        this.invoiceServiceRepository = invoiceServiceRepository;
        this.invoiceProductRepository = invoiceProductRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<InvoiceResponseDTO>> getAll() {
        List<InvoiceResponseDTO> resDTO = invoiceRepository.findAll().stream()
                .map(Mappers::toInvoiceResponseDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(resDTO);
    }

    public ResponseEntity<InvoiceResponseDTO> getOne(Integer invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new FeatureNotFoundException("Invoice", invoiceId));
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toInvoiceResponseDTO(invoice));
    }

    public ResponseEntity<InvoiceResponseDTO> create(InvoiceRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new FeatureNotFoundException("User", dto.getUserId()));
        Invoice invoice = new Invoice();
        LocalDate today = LocalDate.now();
        invoice.setInvoiceDate(today);
        //invoice.setInvoiceDate(dto.getInvoiceDate());
        invoice.setInvoiceStatus(dto.getInvoiceStatus());
        invoice.setAddress(dto.getAddress());
        if (dto.getDateOrder().isBefore(today))
            throw new IllegalArgumentException("La fecha de orden no puede ser anterior a " + invoice.getInvoiceDate());
        invoice.setDateOrder(dto.getDateOrder());
        invoice.setUser(user);

        Invoice saved = invoiceRepository.save(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toInvoiceResponseDTO(saved));
    }

    public ResponseEntity<InvoiceResponseDTO> update(Integer invoiceId, InvoiceRequestDTO dto) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new FeatureNotFoundException("Invoice", invoiceId));
        invoice.setInvoiceStatus(dto.getInvoiceStatus());
        invoice.setAddress(dto.getAddress());
        if (dto.getDateOrder().isBefore(invoice.getInvoiceDate()))
            throw new IllegalArgumentException("La fecha no puede ser anterior a " + invoice.getInvoiceDate());
        invoice.setDateOrder(dto.getDateOrder());

        Invoice saved = invoiceRepository.save(invoice);
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toInvoiceResponseDTO(saved));
    }

    public ResponseEntity<Void> delete(Integer invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new FeatureNotFoundException("Invoice", invoiceId));
        invoiceRepository.delete(invoice);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<InvoiceProductResponseDTO> addProduct(Integer invoiceId, CartProductResponseDTO productCart) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new FeatureNotFoundException("Invoice", invoiceId));
        Product product = productRepository.findById(productCart.getProductId())
                .orElseThrow(() -> new FeatureNotFoundException("Product", productCart.getProductId()));
        InvoiceProduct invoiceProduct = new InvoiceProduct();
        invoiceProduct.setProduct(product);
        invoiceProduct.setInvoice(invoice);
        invoiceProduct.setCount(productCart.getQuantity());
        invoiceProduct.setPrice(productCart.getPrice());

        InvoiceProduct saved = invoiceProductRepository.save(invoiceProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toInvoiceProductResponseDTO(saved));
    }

    public ResponseEntity<InvoiceServiceResponseDTO> addService(Integer invoiceId, CartServicioResponseDTO serviceCart) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new FeatureNotFoundException("Invoice", invoiceId));
        Servicio servicio = servicioRepository.findById(serviceCart.getServiceId())
                .orElseThrow(() -> new FeatureNotFoundException("Servicio", serviceCart.getServiceId()));
        InvoiceServiceEntity invoiceService = new InvoiceServiceEntity();
        invoiceService.setInvoice(invoice);
        invoiceService.setServicio(servicio);
        invoiceService.setPrice(serviceCart.getPrice());

        InvoiceServiceEntity saved = invoiceServiceRepository.save(invoiceService);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toInvoiceServicioResponseDTO(saved));
    }
}
