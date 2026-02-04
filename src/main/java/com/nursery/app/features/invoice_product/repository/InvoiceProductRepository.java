package com.nursery.app.features.invoice_product.repository;

import com.nursery.app.features.invoice_product.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Integer> {
    Optional<InvoiceProduct> findByInvoiceInvoiceIdAndProductProductId(Integer invoiceId, Integer productId);
}
