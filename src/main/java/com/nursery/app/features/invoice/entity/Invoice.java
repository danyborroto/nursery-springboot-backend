package com.nursery.app.features.invoice.entity;

import com.nursery.app.features.invoice_product.entity.InvoiceProduct;
import com.nursery.app.features.invoice_servicio.entity.InvoiceServiceEntity;
import com.nursery.app.features.users.entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "invoice_status")
    private String invoiceStatus;
    @Column(name = "invoice_date")
    private LocalDate invoiceDate;
    @Column(name = "address")
    private String address;
    @Column(name = "date_order")
    private LocalDate dateOrder;

    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<InvoiceProduct> invoiceProducts=new ArrayList<>();
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<InvoiceServiceEntity> invoiceServicios = new ArrayList<>();

    public Invoice() {
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public List<InvoiceProduct> getInvoiceProducts() {
        return invoiceProducts;
    }

    public void setInvoiceProducts(List<InvoiceProduct> invoiceProducts) {
        this.invoiceProducts = invoiceProducts;
    }

    public List<InvoiceServiceEntity> getInvoiceServicios() {
        return invoiceServicios;
    }

    public void setInvoiceServicios(List<InvoiceServiceEntity> invoiceServicios) {
        this.invoiceServicios = invoiceServicios;
    }
}
