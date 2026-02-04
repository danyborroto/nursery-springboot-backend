package com.nursery.app.features.invoice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class InvoiceRequestDTO {
    @Positive(message = "El valor tiene que ser mayor que 0")
    private Integer userId;
    @NotBlank(message = "El estatus es obligatorio")
    private String invoiceStatus;
    //private LocalDate invoiceDate;
    @NotBlank(message = "La direccion es obligatoria")
    private String address;
    private LocalDate dateOrder;

    public InvoiceRequestDTO() {
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

    /*public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }*/

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
}
