package com.nursery.app.features.invoice.dto;

import com.nursery.app.features.invoice_product.dto.InvoiceProductResponseDTO;
import com.nursery.app.features.invoice_servicio.dto.InvoiceServiceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class InvoiceResponseDTO {
    private Integer invoiceId;
    private Integer userId;
    private String invoiceStatus;
    private LocalDate invoiceDate;
    private String address;
    private LocalDate dateOrder;
    private List<InvoiceProductResponseDTO> products;
    private List<InvoiceServiceResponseDTO> servicios;

    public InvoiceResponseDTO() {
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public List<InvoiceProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<InvoiceProductResponseDTO> products) {
        this.products = products;
    }

    public List<InvoiceServiceResponseDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<InvoiceServiceResponseDTO> servicios) {
        this.servicios = servicios;
    }
}
