package com.nursery.app.features.invoice_servicio.repository;

import com.nursery.app.features.invoice_servicio.entity.InvoiceServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceServiceRepository extends JpaRepository<InvoiceServiceEntity, Integer> {
    Optional<InvoiceServiceEntity> findByInvoiceInvoiceIdAndServicioServiceId(Integer invoiceId, Integer servicioId);
}
