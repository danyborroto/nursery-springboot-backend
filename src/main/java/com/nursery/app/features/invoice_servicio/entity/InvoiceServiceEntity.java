package com.nursery.app.features.invoice_servicio.entity;

import com.nursery.app.features.invoice.entity.Invoice;
import com.nursery.app.features.servicio.entity.Servicio;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_service")
public class InvoiceServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
    @Column(name = "price", columnDefinition = "NUMERIC")
    private Double price;

    public InvoiceServiceEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
