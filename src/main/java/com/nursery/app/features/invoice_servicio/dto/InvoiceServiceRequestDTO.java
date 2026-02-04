package com.nursery.app.features.invoice_servicio.dto;

import jakarta.validation.constraints.Positive;

public class InvoiceServiceRequestDTO {
    @Positive(message = "El precio tiene que ser mayor que 0")
    private Double price;

    public InvoiceServiceRequestDTO() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
