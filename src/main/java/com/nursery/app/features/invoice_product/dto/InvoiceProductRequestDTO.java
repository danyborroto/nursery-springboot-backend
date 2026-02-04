package com.nursery.app.features.invoice_product.dto;

import jakarta.validation.constraints.Positive;

public class InvoiceProductRequestDTO {
    @Positive(message = "El precio tiene que ser mayor que 0")
    private Double price;
    @Positive(message = "La cantidad tiene que ser mayor que 0")
    private Integer count;

    public InvoiceProductRequestDTO() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
