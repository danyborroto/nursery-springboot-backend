package com.nursery.app.features.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String productName;
    @PositiveOrZero(message = "El precio no puede ser menor que 0")
    private Double productPrice;
    @NotBlank(message = "La descripcion es obligatoria")
    private String productDescription;
    @PositiveOrZero(message = "La cantidad no puede ser menor que 0")
    private Integer productCount;
    @PositiveOrZero(message = "La atura no puede ser menor que 0")
    private Double productHeight;
    @NotBlank(message = "La unidad de medida es obligatoria")
    private String productHeightUnit;
    @NotNull(message = "El formato es obligatorio")
    @Positive(message = "El formato no puede ser negativo")
    private Integer formatId;
    private Boolean active;

    public ProductRequestDTO(){}

    public ProductRequestDTO(String productName, Double productPrice, String productDescription,
                             Integer productCount, Double productHeight, String productHeightUnit,
                             Integer formatId, Boolean active) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCount = productCount;
        this.productHeight = productHeight;
        this.productHeightUnit = productHeightUnit;
        this.formatId = formatId;
        this.active = active;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Double productHeight) {
        this.productHeight = productHeight;
    }

    public String getProductHeightUnit() {
        return productHeightUnit;
    }

    public void setProductHeightUnit(String productHeightUnit) {
        this.productHeightUnit = productHeightUnit;
    }

    public Integer getFormat() {
        return formatId;
    }

    public void setFormat(Integer formatId) {
        this.formatId = formatId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
